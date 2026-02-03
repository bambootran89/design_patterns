/**
 * Concrete Element: Car.
 * <p>
 * Represents a composite car object that accepts visitors.
 * <p>
 * <b>Pattern Role:</b> Concrete Element (Composite).
 * <p>
 * The Car accepts a visitor and allows the visitor to traverse all its parts
 * (wheels, engine, body).
 * This demonstrates the Visitor pattern's ability to perform operations on
 * object structures.
 */
public class Car implements ICarElement {
  ICarElement[] elements;

  public Car() {
    this.elements =
        new ICarElement[] {new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left"), new Wheel("back right"), new Body(), new Engine()};
  }

  public void accept(ICarElementVisitor visitor) {
    for (ICarElement elem : elements) {
      elem.accept(visitor);
    }
    visitor.visit(this);
  }
}
