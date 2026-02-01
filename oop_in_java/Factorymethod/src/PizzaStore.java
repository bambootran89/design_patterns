/**
 * Creator: Pizza Store.
 * <p>
 * Declares the factory method which returns an object of type Product.
 * <p>
 * <b>Pattern Role:</b> Creator.
 * <p>
 * In the Factory Method Pattern, the Creator class defines a template method
 * ({@code orderPizza()})
 * that uses a factory method ({@code createPizza()}) to obtain product objects.
 * <p>
 * The factory method is abstract, delegating instantiation to subclasses.
 * This allows subclasses to determine which concrete Product class to
 * instantiate,
 * while the Creator defines the overall algorithm (prepare, bake, cut, box).
 * <p>
 * This pattern is also known as the "Virtual Constructor" pattern.
 */
public abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza;
    pizza = createPizza(type);

    pizza.prepare();

    pizza.bake();

    pizza.cut();

    pizza.box();

    return pizza;
  }

  abstract Pizza createPizza(String type);
}
