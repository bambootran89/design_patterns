/**
 * Concrete Element: Body.
 * <p>
 * Represents a car body part that can be visited.
 * <p>
 * <b>Pattern Role:</b> Concrete Element (Leaf).
 * <p>
 * Implements the {@code accept()} method to allow visitors to perform
 * operations on the body.
 */
public class Body implements ICarElement {
  public void accept(ICarElementVisitor visitor) {
    visitor.visit(this);
  }
}
