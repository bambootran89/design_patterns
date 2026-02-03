/**
 * Concrete Strategy: Normal Pricing.
 *
 * <p>Implements the standard (full) pricing algorithm.
 *
 * <p><b>Pattern Role:</b> Concrete Strategy.
 *
 * <p>Returns the raw price without any discount. This strategy is used during normal
 * business hours when no special promotions are active.
 */
public class NormalStrategy implements BillingStrategy {
  @Override
  public double getActPrice(double rawPrice) {
    return rawPrice;
  }
}
