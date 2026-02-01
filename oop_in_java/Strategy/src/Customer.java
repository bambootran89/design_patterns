import java.util.ArrayList;
import java.util.List;

/**
 * Context: Customer.
 * <p>
 * Maintains a reference to a Strategy object and delegates pricing to it.
 * <p>
 * <b>Pattern Role:</b> Context.
 * <p>
 * The Customer class uses a BillingStrategy to calculate prices. The strategy
 * can be changed at runtime ({@code setStrategy()}), allowing the customer to
 * switch between normal and happy hour pricing dynamically.
 */
public class Customer {
  private List<Double> drinks;
  private BillingStrategy strategy;

  public Customer(BillingStrategy strategy) {
    this.drinks = new ArrayList<Double>();
    this.strategy = strategy;
  }

  public void add(double price, int quantity) {
    drinks.add(strategy.getActPrice(price * quantity));
  }

  public double getTotalDue() {
    double sum = 0;
    for (Double i : drinks) {
      sum += i;
    }
    return sum;
  }

  public void printBill() {
    double sum = 0;
    for (Double i : drinks) {
      sum += i;
    }
    System.out.println("Total due: " + sum);
    drinks.clear();
  }

  public void setStrategy(BillingStrategy strategy) {
    this.strategy = strategy;
  }
}
