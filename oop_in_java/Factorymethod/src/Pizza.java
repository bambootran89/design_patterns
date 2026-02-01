import java.util.ArrayList;

/**
 * Product: Pizza.
 * <p>
 * Defines the interface for objects the factory method creates.
 * <p>
 * <b>Pattern Role:</b> Product.
 * <p>
 * In the Factory Method pattern, this is the abstract product. Concrete
 * products
 * (NYStyleCheesePizza, ChicagoStyleCheesePizza) extend this class and customize
 * the name, dough, sauce, and toppings. The template methods (prepare, bake,
 * cut, box)
 * define the standard pizza-making algorithm.
 */
public class Pizza {
  String name;
  String dough;
  String sauce;
  ArrayList<String> toppings = new ArrayList<String>();

  void prepare() {
    System.out.println("Preparing ..." + name);
    System.out.println("Tossing dough ...");
    System.out.println("Adding sauce ...");
    System.out.println("Adding toppings: ");
    for (int i = 0; i < toppings.size(); i++) {

      System.out.println("  " + toppings.get(i));
    }
  }

  void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  void cut() {

    System.out.println("Cutting the pizza into diagonal slices");
  }

  void box() {
    System.out.println("Place pizza in officical PizzaStore box");
  }

  public String getName() {

    return name;
  }
}
