/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza pizza = nyStore.orderPizza("cheese");

    System.out.println("Ethan ordered a " + pizza.getName());
    pizza = chicagoStore.orderPizza("cheese");

    System.out.println("Joel ordered a " + pizza.getName());
  }
}
