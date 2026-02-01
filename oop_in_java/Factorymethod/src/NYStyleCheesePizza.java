/**
 * Concrete Product: NY Style Cheese Pizza.
 * <p>
 * Implements a New York style cheese pizza with thin crust.
 * <p>
 * <b>Pattern Role:</b> Concrete Product.
 * <p>
 * Customizes the Pizza product with NY-specific characteristics (thin crust
 * dough,
 * marinara sauce). Created by NYPizzaStore's factory method.
 */
public class NYStyleCheesePizza extends Pizza {
  public NYStyleCheesePizza() {
    name = "NY Styte Sauce and Cheese Pizza";
    dough = "Thin Crust Dough";
    sauce = "Marrinara Sauce";
    toppings.add("Granted Reffiano Cheese");
    toppings.add("Granted " + dough);
    toppings.add("Granted " + sauce);
  }
}
