/**
 * Concrete Decorator: Mocha.
 *
 * <p>Adds mocha flavoring to a beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Decorator.
 */
public class Mocha extends CondimentDecorator {
  Beverage beverage;

  public Mocha(Beverage b) {
    beverage = b;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + " Mocha";
  }

  @Override
  public Double cost() {
    return beverage.cost() + 4.23;
  }
}
