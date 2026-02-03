/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    TeaWithHook teaWithHook = new TeaWithHook();
    CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

    System.out.println("Making tea ...");
    teaWithHook.prepareRecipe();
    System.out.println("Making coffee ..");
    coffeeWithHook.prepareRecipe();
  }
}
