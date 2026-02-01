/**
 * Concrete Component: Espresso.
 * <p>
 * Base espresso beverage.
 * <p>
 * <b>Pattern Role:</b> Concrete Component.
 */
public class Espresso extends Beverage {

  public Espresso() {
    // TODO Auto-generated constructor stub
    description = "Espresso";
  }

  @Override
  public Double cost() {
    // TODO Auto-generated method stub
    return 230.45;
  }
}
