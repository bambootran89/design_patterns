/**
 * Strategy Interface: Billing Strategy.
 * <p>
 * Defines the interface for different billing algorithms.
 * <p>
 * <b>Pattern Role:</b> Strategy.
 * <p>
 * The Strategy pattern defines a family of algorithms (NormalStrategy,
 * HappyHourStrategy),
 * encapsulates each one, and makes them interchangeable. This interface allows
 * the algorithm
 * to vary independently from clients that use it.
 */
public interface BillingStrategy {
  public double getActPrice(double rawPrice);
}
