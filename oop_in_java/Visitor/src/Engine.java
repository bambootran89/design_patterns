/**
 * Concrete Element: Engine.
 * <p>
 * Represents an engine part that can be visited.
 * <p>
 * <b>Pattern Role:</b> Concrete Element (Leaf).
 * <p>
 * Implements the {@code accept()} method to allow visitors to perform
 * operations on the engine.
 */
public class Engine implements ICarElement {
  public void accept(ICarElementVisitor visitor) {
    visitor.visit(this);
  }
}
