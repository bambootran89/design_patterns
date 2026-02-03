/**
 * Concrete Builder: Car Builder.
 *
 * <p>Implements the building steps to construct a Car object.
 *
 * <p><b>Pattern Role:</b> Concrete Builder.
 *
 * <p>This builder maintains an internal Car instance and provides methods to configure
 * it incrementally. Once all desired properties are set, {@code getResult()} returns
 * the constructed Car.
 *
 * <p>The Builder pattern is particularly useful when:
 * <ul>
 *   <li>The object has many optional parameters.
 *   <li>Construction requires multiple steps.
 *   <li>You want to avoid telescoping constructors.
 * </ul>
 */
public class CarBuilder implements ICarBuilder {
  private Car car;

  public CarBuilder() {
    car = new Car();
  }

  @Override
  public void setColour(String colour) {
    car.colours = colour;
  }

  @Override
  public void setWheels(int count) {
    car.wheels = count;
  }

  @Override
  public Car getResult() {
    return this.car;
  }
}
