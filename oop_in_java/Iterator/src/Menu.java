/**
 * Aggregate Interface: Menu.
 *
 * <p>Declares an interface for creating an Iterator object.
 *
 * <p><b>Pattern Role:</b> Aggregate.
 *
 * <p>In the Iterator pattern, aggregates implement {@code createIterator()} to return
 * an appropriate iterator for their collection. This decouples iteration from the
 * underlying collection structure (array, list, etc.).
 */
public interface Menu {
  Iterator createIterator();
}
