/**
 * Abstract Decorator.
 * <p>
 * This class is key to the Decorator Pattern: it <i>is</i> a Beverage
 * (Inheritance)
 * but also <i>contains</i> a Beverage (Composition, though implicitly via
 * subclasses here).
 * <p>
 * <b>Pattern Role:</b> Decorator.
 * <p>
 * It forces all concrete decorators (Milk, Soy, Mocha) to reimplement the
 * `getDescription`
 * method to append their own description to the wrapped object's description.
 * This ensures the behavior (description + cost) is additive.
 */
public abstract class CondimentDecorator extends Beverage {
  public abstract String getDescription();
}
