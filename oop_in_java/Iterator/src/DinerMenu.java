/**
 * Concrete Aggregate: Diner Menu.
 *
 * <p>Stores menu items in an array and provides an iterator for them.
 *
 * <p><b>Pattern Role:</b> Concrete Aggregate.
 *
 * <p>Uses an array to store MenuItem objects. The {@code createIterator()} method
 * returns a DinerMenuIterator that knows how to iterate over the array structure. This
 * demonstrates how different collection types (array vs ArrayList) can be hidden behind
 * a common Iterator interface.
 */
public class DinerMenu implements Menu {
  static final int MAX_ITEMS = 8;
  int numberOfItems = 0;
  MenuItem[] menuItems = new MenuItem[MAX_ITEMS];

  /** Constructs a new DinerMenu with default items. */
  public DinerMenu() {
    addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato  on whole wheat",
        true, 2.8999);
    addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.85559);
    addItem(
        "Soup of the day", "Soup of the day, with a side of potato salad", false, 3.45);
    addItem("Hotdog", "a hot dog, with saurkraut, relish, onions, topped with cheese",
        false, 3.00058);
  }

  /**
   * Adds an item to the menu.
   *
   * @param name name of the item
   * @param description description of the item
   * @param vegetarian whether it's vegetarian
   * @param price price of the item
   */
  public void addItem(
      String name, String description, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
    if (numberOfItems >= MAX_ITEMS) {
      System.err.println("Sorry, Menu is full! can't add item to menu");
    } else {
      menuItems[numberOfItems] = menuItem;
      numberOfItems++;
    }
  }

  /**
   * Returns the array of menu items.
   *
   * @return the array of menu items
   */
  public MenuItem[] getMenuItems() {
    return menuItems;
  }

  @Override
  public Iterator createIterator() {
    return new DinerMenuIterator(menuItems);
  }
}
