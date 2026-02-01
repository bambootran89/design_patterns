/**
 * Concrete Component: Decaf.
 * <p>
 * Base decaffeinated coffee beverage.
 * <p>
 * <b>Pattern Role:</b> Concrete Component.
 */
public class Decaf extends Beverage {

  public Decaf() {
    // TODO Auto-generated constructor stub
    description = "Decaf";
  }

  @Override
  public Double cost() {
    // TODO Auto-generated method stub
    return 3.45;
  }
}
