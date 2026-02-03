import java.util.ArrayList;
import java.util.List;

/**
 * Context: Customer.
 *
 * <p>Maintains a reference to a Strategy object and delegates pricing to it.
 *
 * <p><b>Pattern Role:</b> Context.
 *
 * <p>The Customer class uses a BillingStrategy to calculate prices. The strategy can be
 * changed at runtime ({@code setStrategy()}), allowing the customer to switch between
 * normal and happy hour pricing dynamically.
 */
public class Customer {
  private List<Double> drinks;
  private BillingStrategy strategy;

  /**
   * Constructs a new Customer with a billing strategy.
   *
   * @param strategy the initial billing strategy
   */
  public Customer(BillingStrategy strategy) {
    this.drinks = new ArrayList<Double>();
    this.strategy = strategy;
  }

  /**
   * Adds a drink to the bill.
   *
   * @param price price of the drink
   * @param quantity quantity of drinks
   */
  public void add(double price, int quantity) {
    drinks.add(strategy.getActPrice(price * quantity));
  }

  /**
   * Calculates the total due.
   *
   * @return total price
   */
  public double getTotalDue() {
    double sum = 0;
    for (Double i : drinks) {
      sum += i;
    }
    return sum;
  }

  /** Prints the bill and clears the drink list. */
  public void printBill() {
    double sum = 0;
    for (Double i : drinks) {
      sum += i;
    }
    System.out.println("Total due: " + sum);
    drinks.clear();
  }

  /**
   * Sets a new billing strategy.
   *
   * @param strategy the new billing strategy
   */
  public void setStrategy(BillingStrategy strategy) {
    this.strategy = strategy;
  }
}
