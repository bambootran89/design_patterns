/**
 * Concrete Decorator: Soy.
 *
 * <p>Adds soy milk to a beverage.
 *
 * <p><b>Pattern Role:</b> Concrete Decorator.
 */
public class Soy extends CondimentDecorator {
  Beverage beverage;

  public Soy(Beverage b) {
    beverage = b;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + " Soy";
  }

  @Override
  public Double cost() {
    return beverage.cost() + 123.23;
  }
}
