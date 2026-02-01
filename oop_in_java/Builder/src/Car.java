/**
 * Product: Car.
 * <p>
 * The complex object being constructed by the Builder.
 * <p>
 * <b>Pattern Role:</b> Product.
 * <p>
 * In the Builder pattern, the Product is the object under construction.
 * It typically has multiple configurable properties (wheels, colours) that
 * are set through the Builder interface rather than through a complex
 * constructor.
 * <p>
 * The Product class itself remains simple and focuses on its core
 * responsibilities,
 * while the Builder handles the construction logic.
 */
public class Car {
  public Car() {
  }

  public int Wheels;
  public String Colours;

  public void printCar() {
    System.out.println(
        "Created Car with colour is " + Colours + " and it has " + Wheels + " Wheels");
  }
}
