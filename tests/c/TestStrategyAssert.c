#define main pattern_main
#include "../../oop_in_c/Strategy/Strategy.c"
#undef main
#include <assert.h>
#include <math.h>
#include <stdio.h>

#define EPSILON 0.0001
#define ASSERT_DOUBLE_EQ(x, y) assert(fabs((x) - (y)) < EPSILON)

int main() {
    printf("Testing C Strategy with Assertions...\n");
    
    // Setup
    HappyHourStrategy happyStrategy; HappyHourStrategy_ctor(&happyStrategy, 0.5);
    NormalStrategy normalStrategy; NormalStrategy_ctor(&normalStrategy);
    Customer a; Customer_ctor(&a, (BillingStrategy*)&normalStrategy);
    
    // Action 1: Add item with Normal Strategy
    customer_add(&a, 1.0, 1);
    // Calculation: 1.0 * 1 = 1.0
    // Sum: 1.0
    ASSERT_DOUBLE_EQ(Customer_getSum(&a), 1.0);
    
    // Action 2: Change to Happy Hour (50% off) and add item
    customer_set(&a, (BillingStrategy*)&happyStrategy);
    customer_add(&a, 1.0, 2);
    // Calculation: 1.0 * 0.5 * 2 = 1.0
    // Sum: 1.0 (previous) + 1.0 (current) = 2.0
    ASSERT_DOUBLE_EQ(Customer_getSum(&a), 2.0);
    
    printf("C Strategy Assert Test Passed!\n");
    return 0;
}
