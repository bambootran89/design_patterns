/**
 * Concrete Creator: NY Pizza Store.
 *
 * <p>Overrides the factory method to create NY-style pizza products.
 *
 * <p><b>Pattern Role:</b> Concrete Creator.
 *
 * <p>This class implements the factory method ({@code createPizza()}) to instantiate
 * concrete products (NYStyleCheesePizza). Each regional store (NY, Chicago) creates
 * region-specific pizzas while inheriting the common ordering workflow from PizzaStore.
 *
 * <p>The Factory Method Pattern allows adding new pizza styles (e.g.,
 * CaliforniaPizzaStore) without modifying the PizzaStore class.
 */
public class NYPizzaStore extends PizzaStore {
  @Override
  Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NYStyleCheesePizza();
    } else {
      return null;
    }
  }
}
