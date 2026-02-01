/**
 * Concrete Product: Chicago Style Cheese Pizza.
 * <p>
 * Implements a Chicago style deep dish cheese pizza.
 * <p>
 * <b>Pattern Role:</b> Concrete Product.
 * <p>
 * Customizes the Pizza product with Chicago-specific characteristics (extra
 * thin
 * crust, plum tomato sauce) and overrides {@code cut()} to use square slices
 * instead of diagonal. Created by ChicagoPizzaStore's factory method.
 */
public class ChicagoStyleCheesePizza extends Pizza {
  public ChicagoStyleCheesePizza() {
    // TODO Auto-generated constructor stub
    name = "Chicago Style Deep Dish Cheese Pizza";
    dough = "Extra Thin Crust Dough";
    sauce = "Plum Tomato Sauce";
    toppings.add("Shredded Mozzarella Cheese");
    toppings.add("Shredded " + dough);
    toppings.add("Shredded " + sauce);
  }

  void cut() {
    System.out.println("Cutting the pizza into square slices");
  }
}
