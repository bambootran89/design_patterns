/**
 * Component Interface (Beverage).
 *
 * <p>Defines the common interface for all coffee beverages (both base components and
 * decorators).
 *
 * <p><b>Pattern Role:</b> Component.
 *
 * <p>The Decorator pattern uses this interface to allow objects to be dynamically
 * extended. Clients program to this {@code Beverage} type, unaware of whether they are
 * dealing with a simple {@code Espresso} or a complex recursive chain like {@code
 * Whip(Mocha(Espresso))}.
 */
public abstract class Beverage {
  /** @param args */
  protected String description = "Unknow";

  public String getDescription() {
    return description;
  }

  public abstract Double cost();
}
