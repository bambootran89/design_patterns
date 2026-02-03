/**
 * Concrete Decorator: Milk.
 *
 * <p>Adds milk to a beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Decorator.
 */
public class Milk extends CondimentDecorator {
  Beverage beverage;

  public Milk(Beverage b) {
    beverage = b;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + " Milk";
  }

  @Override
  public Double cost() {
    return beverage.cost() + 45.23;
  }
}
