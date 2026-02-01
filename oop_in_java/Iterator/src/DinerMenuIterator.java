/**
 * Concrete Iterator: DinerMenu Iterator.
 * <p>
 * Implements the Iterator interface for array-based collections.
 * <p>
 * <b>Pattern Role:</b> Concrete Iterator.
 * <p>
 * This iterator maintains the current position and implements traversal logic
 * for an array of MenuItems. It handles boundary checks (null elements, end of
 * array)
 * internally, simplifying client code.
 * <p>
 * Different collection types (ArrayList, HashMap) can have different concrete
 * iterators,
 * all conforming to the same Iterator interface.
 */
public class DinerMenuIterator implements Iterator {
  MenuItem[] items;
  int position = 0;

  public DinerMenuIterator(MenuItem[] items) {
    // TODO Auto-generated constructor stub
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    if (position >= items.length || items[position] == null) {

      return false;

    } else
      return true;
  }

  @Override
  public Object next() {
    // TODO Auto-generated method stub
    MenuItem menuItem = items[position];
    position = position + 1;

    return menuItem;
  }
}
