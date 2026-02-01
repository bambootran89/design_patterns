/**
 * Client / Director.
 * <p>
 * Demonstrates usage of the Builder pattern to construct a Car.
 * <p>
 * <b>Pattern Role:</b> Director (or Client).
 * <p>
 * The {@code construct()} method acts as a Director, orchestrating the
 * construction sequence:
 * 1. Create a Builder instance.
 * 2. Call building methods in sequence (setColour, setWheels).
 * 3. Retrieve the final product.
 * <p>
 * This separation allows the same building process to create different
 * representations by using different Builder implementations.
 */
public class Client {
  public static Car construct() {
    ICarBuilder builder = new CarBuilder();
    builder.setColour("Red");
    builder.setWheels(4);
    return builder.getResult();
  }

  public static void main(String[] args) {

    construct().printCar();
  }
}
