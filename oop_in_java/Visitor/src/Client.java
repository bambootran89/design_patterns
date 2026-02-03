/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    ICarElement car = new Car();
    car.accept(new CarElementPrintVisitor());
    car.accept(new CarElementDoVisitor());
  }
}
