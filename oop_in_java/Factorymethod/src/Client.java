/** Client demonstration code for the pattern. */
public class Client {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza pizza = nyStore.orderPizza("cheese");

    System.out.println("Ethan ordered a " + pizza.getName());
    pizza = chicagoStore.orderPizza("cheese");

    System.out.println("Joel ordered a " + pizza.getName());
  }
}
