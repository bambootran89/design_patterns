/**
 * Concrete Strategy: Happy Hour Pricing.
 *
 * <p>Implements a 50% discount pricing algorithm.
 *
 * <p><b>Pattern Role:</b> Concrete Strategy.
 *
 * <p>Returns half the raw price. This strategy is used during happy hour promotions to
 * encourage customer purchases.
 */
public class HappyHourStrategy implements BillingStrategy {
  @Override
  public double getActPrice(double rawPrice) {
    return rawPrice * 0.5;
  }
}
