import java.util.ArrayList;

/**
 * Concrete Iterator: Pancake House Iterator.
 * <p>
 * Iterates over ArrayList-based menu items.
 * <p>
 * <b>Pattern Role:</b> Concrete Iterator.
 * <p>
 * Wraps Java's ArrayList iterator to provide a uniform iteration interface.
 */
public class PancakeHouseIterator implements Iterator {
  ArrayList<MenuItem> items;
  java.util.Iterator<MenuItem> iterator;

  public PancakeHouseIterator(ArrayList<MenuItem> items) {
    // TODO Auto-generated constructor stub
    this.items = items;
    iterator = items.iterator();
  }

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return iterator.hasNext();
  }

  @Override
  public Object next() {
    // TODO Auto-generated method stub

    return iterator.next();
  }
}
