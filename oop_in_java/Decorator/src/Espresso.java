/**
 * Concrete Component: Espresso.
 *
 * <p>Base espresso beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Component.
 */
public class Espresso extends Beverage {
  public Espresso() {
    description = "Espresso";
  }

  @Override
  public Double cost() {
    return 230.45;
  }
}
