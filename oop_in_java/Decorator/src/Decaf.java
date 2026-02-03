/**
 * Concrete Component: Decaf.
 *
 * <p>Base decaffeinated coffee beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Component.
 */
public class Decaf extends Beverage {
  public Decaf() {
    description = "Decaf";
  }

  @Override
  public Double cost() {
    return 3.45;
  }
}
