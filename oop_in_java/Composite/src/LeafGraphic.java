/**
 * Leaf: Individual Graphic Element.
 * <p>
 * Represents leaf objects in the composition (objects with no children).
 * <p>
 * <b>Pattern Role:</b> Leaf.
 * <p>
 * A Leaf defines behavior for primitive objects. It implements all Component
 * operations
 * but has no child management methods (since it cannot contain children).
 * <p>
 * In this example, LeafGraphic represents individual graphic elements like
 * circles or squares.
 */
public class LeafGraphic implements Graphic {
  private String name;

  public LeafGraphic(String n) {
    name = n;
  }

  @Override
  public void print() {
    // TODO Auto-generated method stub
    System.out.println("This is a Leaf " + name);
  }
}
