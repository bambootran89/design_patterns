/**
 * Iterator Interface.
 * <p>
 * Provides a way to access elements of a collection sequentially without
 * exposing its underlying representation.
 * <p>
 * <b>Pattern Role:</b> Iterator.
 * <p>
 * The Iterator Pattern allows traversing different collection types (array,
 * list, tree)
 * using a common interface ({@code hasNext()}, {@code next()}).
 * <p>
 * Benefits:
 * - Hides internal collection structure from clients.
 * - Supports multiple simultaneous traversals.
 * - Provides a uniform way to iterate over different collection types.
 */
public interface Iterator {
  boolean hasNext();

  Object next();
}
