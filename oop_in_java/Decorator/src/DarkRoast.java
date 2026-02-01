/**
 * Concrete Component: Dark Roast.
 * <p>
 * Base dark roast coffee beverage.
 * <p>
 * <b>Pattern Role:</b> Concrete Component.
 */
public class DarkRoast extends Beverage {

  public DarkRoast() {
    // TODO Auto-generated constructor stub
    description = "DarkRoast";
  }

  @Override
  public Double cost() {
    // TODO Auto-generated method stub
    return 23.45;
  }
}
