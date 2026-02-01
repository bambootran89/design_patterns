/** Client demonstration code for the pattern. */
public class client {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ICarElement car = new Car();
    car.accept(new CarElementPrintVisitor());
    car.accept(new CarElementDoVisitor());
  }
}
