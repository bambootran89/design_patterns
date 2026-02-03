/**
 * Concrete Component: Dark Roast.
 *
 * <p>Base dark roast coffee beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Component.
 */
public class DarkRoast extends Beverage {
  public DarkRoast() {
    description = "DarkRoast";
  }

  @Override
  public Double cost() {
    return 23.45;
  }
}
