/**
 * Concrete Element: Wheel.
 * <p>
 * Represents a wheel part with a name (position).
 * <p>
 * <b>Pattern Role:</b> Concrete Element (Leaf).
 * <p>
 * Each wheel has a name (e.g., "front left") and accepts visitors to perform
 * operations on it.
 */
public class Wheel implements ICarElement {
  private String name;

  public Wheel(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void accept(ICarElementVisitor visitor) {
    visitor.visit(this);
  }
}
