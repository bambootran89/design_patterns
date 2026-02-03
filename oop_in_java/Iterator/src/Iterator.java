/**
 * Iterator Interface.
 *
 * <p>Provides a way to access elements of a collection sequentially without exposing
 * its underlying representation.
 *
 * <p><b>Pattern Role:</b> Iterator.
 *
 * <p>The Iterator Pattern allows traversing different collection types (array, list,
 * tree) using a common interface ({@code hasNext()}, {@code next()}).
 *
 * <p>Benefits:
 * <ul>
 *   <li>Hides internal collection structure from clients.
 *   <li>Supports multiple simultaneous traversals.
 *   <li>Provides a uniform way to iterate over different collection types.
 * </ul>
 */
public interface Iterator {
  /**
   * Returns {@code true} if the iteration has more elements.
   *
   * @return {@code true} if the iteration has more elements
   */
  boolean hasNext();

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   */
  Object next();
}
