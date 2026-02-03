#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
/**
 * @brief Abstract Strategy Interface for billing algorithms.
 *
 * The `BillingStrategy` structure defines the common interface (contract) that all
 * supported billing algorithms must adhere to. In the Strategy Design Pattern,
 * this structure corresponds to the **Strategy** participant.
 *
 * @details
 * This structure utilizes a function pointer table (simulating a VTable in C)
 * to achieve polymorphism. Concrete strategies (e.g., `HappyHourStrategy`,
 * `NormalStrategy`) "inherit" from this by embedding it or adhering to its binary
 * layout, allowing the Context (`Customer`) to invoke `getActPrice` without knowing the
 * specific implementation.
 *
 * @see Customer
 * @see HappyHourStrategy
 * @see NormalStrategy
 */
typedef struct BillingStrategy {
  const struct BillingStrategy* const this;
  double (*getActPrice)(struct BillingStrategy* const me, double rawPrice);
} BillingStrategy;

/**
 * @brief Concrete Strategy: Happy Hour Discount.
 *
 * Implements a specific billing algorithm where items are discounted by a configurable
 * factor (typically 50%).
 *
 * @details
 * In the Strategy Design Pattern, this structure corresponds to a **Concrete
 * Strategy**. It encapsulates the specific business logic for promotional pricing.
 *
 * Key features:
 * - Extends `BillingStrategy` via composition/pointer logic.
 * - Stores state (`discount`) specific to this strategy instance.
 *
 * @note This strategy assumes the `rawPrice` is non-negative.
 */
typedef struct HappyHourStrategy {
  const BillingStrategy* super;
  double discount;
} HappyHourStrategy;

static double happyHourStratery_getActPrice(BillingStrategy* const me_,
                                            double rawPrice) {
  HappyHourStrategy* const me = (HappyHourStrategy* const)me_;
  return rawPrice * me->discount;
}

void HappyHourStrategy_ctor(HappyHourStrategy* const me, double discount_) {
  static BillingStrategy const billingStratery = {
      &billingStratery, .getActPrice = happyHourStratery_getActPrice};
  me->super = &billingStratery;
  me->discount = discount_;
}

/**
 * @brief Concrete Strategy: Normal Pricing.
 *
 * Implements the standard billing algorithm where no discount is applied.
 *
 * @details
 * In the Strategy Design Pattern, this corresponds to another **Concrete Strategy**.
 * Unlike `HappyHourStrategy`, this implementation creates a baseline behavior
 * (identity transformation on price).
 *
 * It demonstrates how different algorithms can be interchangeable within the `Customer`
 * context despite having different internal complexity (this one has no state).
 */
typedef struct NormalStrategy {
  const BillingStrategy* super;
} NormalStrategy;

static double normalStratery_getActPrice(BillingStrategy* const me_, double rawPrice) {
  return rawPrice;
}

void NormalStrategy_ctor(NormalStrategy* const me) {
  static BillingStrategy const billingStratery = {
      &billingStratery, .getActPrice = normalStratery_getActPrice};
  me->super = &billingStratery;
}

double getActPrice(BillingStrategy* const me, double rawPrice) {
  return me->this->getActPrice(me, rawPrice);
}
/**
 * @brief Context: The Client consuming the Strategy.
 *
 * The `Customer` structure represents the **Context** participant in the Strategy
 * Pattern. It is configured with a `BillingStrategy` object and delegates the price
 * calculation to it.
 *
 * @details
 * By holding a pointer to the abstract `BillingStrategy`, the `Customer` class remains
 * decoupled from the specific implementation details of pricing. This allows the
 * pricing algorithm to be switched at runtime (e.g., entering/leaving Happy Hour)
 * without modifying the `Customer` code.
 *
 * **Usage Lifecycle:**
 * 1. Initialize `Customer` with a default strategy (e.g., Normal).
 * 2. Add items (prices are calculated using the current strategy).
 * 3. Change strategy dynamically via `customer_set`.
 * 4. Add more items (calculated with the new strategy).
 * 5. Print bill (aggregates all calculated costs).
 */
typedef struct Customer {
  double list[MAX];
  int numList;
  BillingStrategy* strategy;
} Customer;

void Customer_ctor(Customer* const me, BillingStrategy* const strategy_) {
  me->strategy = strategy_;
  me->numList = 0;
}
void customer_add(Customer* const me, double price, int qualities) {
  me->list[(me->numList)++] = getActPrice(me->strategy, price) * qualities;
}

void customer_set(Customer* const me, BillingStrategy* const strategy_) {
  me->strategy = strategy_;
}

double Customer_getSum(Customer* const me) {
  double sum = 0;
  int i = 0;
  for (i = 0; i < me->numList; i++) {
    sum += me->list[i];
  }
  return sum;
}

void customer_printBill(Customer* const me) {
  double sum = 0;
  int i = 0;
  for (i = 0; i < me->numList; i++) {
    sum += me->list[i];
  }

  printf(" Total due: %lf\n", sum);
  me->numList = 0;
}
main() {
  HappyHourStrategy happyStrategy;
  HappyHourStrategy_ctor(&happyStrategy, 0.5);

  NormalStrategy normalStrategy;
  NormalStrategy_ctor(&normalStrategy);
  Customer a;
  Customer_ctor(&a, (BillingStrategy* const)&normalStrategy);

  customer_add(&a, 1.0, 1);

  customer_set(&a, (BillingStrategy* const)&happyStrategy);

  customer_add(&a, 1.0, 2);

  Customer b;
  Customer_ctor(&b, (BillingStrategy* const)&happyStrategy);

  customer_add(&b, 0.8, 1);

  customer_set(&b, (BillingStrategy* const)&normalStrategy);

  customer_add(&b, 1.3, 2);
  customer_add(&b, 2.5, 1);

  customer_printBill(&a);

  customer_printBill(&b);

  return 0;
}
