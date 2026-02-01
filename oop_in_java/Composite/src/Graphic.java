/**
 * Component Interface: Graphic.
 * <p>
 * Declares the interface for objects in the composition.
 * <p>
 * <b>Pattern Role:</b> Component.
 * <p>
 * In the Composite Pattern, both Leaf and Composite nodes implement this
 * interface,
 * allowing them to be treated uniformly. Clients can work with tree structures
 * without distinguishing between individual objects (leaves) and compositions
 * of objects (composites).
 */
public interface Graphic {
  public void print();
}
