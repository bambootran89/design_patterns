import java.util.ArrayList;

/**
 * Client: Waitress.
 *
 * <p>Uses iterators to print menus without knowing their internal structure.
 *
 * <p><b>Pattern Role:</b> Client.
 *
 * <p>The Waitress works with the Iterator interface, treating all menus uniformly
 * regardless of whether they use arrays or ArrayLists internally. This demonstrates the
 * Iterator pattern's benefit: the client can traverse collections without coupling to
 * their concrete implementations.
 */
public class Waitress {
  /** @param args */
  ArrayList<Menu> menus;

  /**
   * Constructs a new Waitress.
   *
   * @param menus list of menus to print
   */
  public Waitress(ArrayList<Menu> menus) {
    this.menus = menus;
  }

  /** Prints all menus. */
  void prinMenu() {
    for (Menu ms : menus) {
      Iterator tmp = (Iterator) ms.createIterator();
      System.out.println("\n\n" + tmp.getClass().getName() + "\n\n");
      printMenu(tmp);
    }
  }

  /**
   * Prints a single menu using its iterator.
   *
   * @param iterator the iterator to identifying the menu
   */
  void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.println(menuItem.getName() + ", ");
      System.out.println(menuItem.getPrice() + ", ");
      System.out.println(menuItem.getDescription());
    }
  }
}
