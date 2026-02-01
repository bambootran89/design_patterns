/**
 * Concrete Component: House Blend.
 * <p>
 * Base house blend coffee beverage.
 * <p>
 * <b>Pattern Role:</b> Concrete Component.
 */
public class HouseBlend extends Beverage {

  public HouseBlend() {
    // TODO Auto-generated constructor stub
    description = "HouseBlend";
  }

  @Override
  public Double cost() {
    // TODO Auto-generated method stub
    return 23000.45;
  }
}
