/**
 * Concrete Decorator: Whip.
 *
 * <p>Adds whipped cream to a beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Decorator.
 */
public class Whip extends CondimentDecorator {
  Beverage beverage;

  public Whip(Beverage b) {
    beverage = b;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + " Whip";
  }

  @Override
  public Double cost() {
    return beverage.cost() + 23.23;
  }
}
