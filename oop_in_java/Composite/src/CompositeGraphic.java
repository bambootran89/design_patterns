import java.util.ArrayList;
import java.util.List;

/**
 * Composite: Container for Graphic Elements.
 *
 * <p>Defines behavior for components having children and stores child components.
 *
 * <p><b>Pattern Role:</b> Composite.
 *
 * <p>A Composite implements all Component operations and adds operations for managing
 * children (add, remove). When {@code print()} is called, it recursively calls {@code
 * print()} on all its children, creating a tree traversal.
 *
 * <p>This allows building arbitrarily complex tree structures while maintaining a
 * uniform interface. For example, a CompositeGraphic can contain LeafGraphics and other
 * CompositeGraphics.
 */
public class CompositeGraphic implements Graphic {
  private String name;

  private List<Graphic> childGraphics = new ArrayList<Graphic>();

  public CompositeGraphic(String n) {
    name = n;
  }

  @Override
  public void print() {
    System.out.println("This is CompositeGraphic " + name);
    for (Graphic graphic : childGraphics) {
      graphic.print();
    }
  }

  public void add(Graphic graphic) {
    childGraphics.add(graphic);
  }

  public void remove(Graphic graphic) {
    childGraphics.remove(graphic);
  }
}
