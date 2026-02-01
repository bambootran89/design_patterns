/**
 * Concrete Builder: Car Builder.
 * <p>
 * Implements the building steps to construct a Car object.
 * <p>
 * <b>Pattern Role:</b> Concrete Builder.
 * <p>
 * This builder maintains an internal Car instance and provides methods
 * to configure it incrementally. Once all desired properties are set,
 * {@code getResult()} returns the constructed Car.
 * <p>
 * The Builder pattern is particularly useful when:
 * - The object has many optional parameters.
 * - Construction requires multiple steps.
 * - You want to avoid telescoping constructors.
 */
public class CarBuilder implements ICarBuilder {

  private Car car;

  public CarBuilder() {
    car = new Car();
  }

  @Override
  public void setColour(String colour) {
    // TODO Auto-generated method stub
    car.Colours = colour;
  }

  @Override
  public void setWheels(int count) {
    // TODO Auto-generated method stub
    car.Wheels = count;
  }

  @Override
  public Car getResult() {
    // TODO Auto-generated method stub
    return this.car;
  }
}
