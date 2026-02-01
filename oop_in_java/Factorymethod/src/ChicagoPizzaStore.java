/**
 * Concrete Creator: Chicago Pizza Store.
 * <p>
 * Implements the factory method to create Chicago-style pizzas.
 * <p>
 * <b>Pattern Role:</b> Concrete Creator.
 * <p>
 * Overrides {@code createPizza()} to instantiate ChicagoStyleCheesePizza.
 * Inherits the {@code orderPizza()} template method from PizzaStore.
 */
public class ChicagoPizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String type) {
    // TODO Auto-generated method stub
    if (type.equals("cheese"))
      return new ChicagoStyleCheesePizza();
    else
      return null;
  }
}
