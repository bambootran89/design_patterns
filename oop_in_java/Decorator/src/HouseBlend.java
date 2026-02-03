/**
 * Concrete Component: House Blend.
 *
 * <p>Base house blend coffee beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Component.
 */
public class HouseBlend extends Beverage {
  public HouseBlend() {
    description = "HouseBlend";
  }

  @Override
  public Double cost() {
    return 23000.45;
  }
}
