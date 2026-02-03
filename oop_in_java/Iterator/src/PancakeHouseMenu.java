import java.util.ArrayList;

/**
 * Concrete Aggregate: Pancake House Menu.
 *
 * <p>Stores menu items in an ArrayList and provides an iterator for them.
 *
 * <p><b>Pattern Role:</b> Concrete Aggregate.
 *
 * <p>Uses ArrayList to store MenuItem objects, contrasting with DinerMenu's array.
 * Despite different internal structures, both implement the same Menu interface and
 * return iterators, demonstrating the Iterator pattern's power to hide implementation
 * details.
 */
public class PancakeHouseMenu implements Menu {
  ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

  /** Constructs a new PancakeHouseMenu with default items. */
  public PancakeHouseMenu() {
    addItem("K&B's Pancake Breakfast", "Pancakes with fried eggs, toast", true, 2.89);
    addItem(
        "Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.89);
    addItem("Blueberry Pancake", "Pancakes with fresh blueberries", true, 3.45);
    addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true,
        3.58);
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
    menuItems.add(menuItem);
  }

  /**
   * Returns the list of menu items.
   *
   * @return the list of menu items
   */
  public ArrayList<MenuItem> getMenuItems() {
    return menuItems;
  }

  @Override
  public Iterator createIterator() {
    return new PancakeHouseIterator(menuItems);
  }
}
