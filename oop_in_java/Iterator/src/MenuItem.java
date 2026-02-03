/**
 * Menu Item: Data Object.
 *
 * <p>Represents a single menu item with name, description, vegetarian flag, and price.
 *
 * <p><b>Pattern Role:</b> Element (Data Object).
 *
 * <p>In the Iterator pattern, this is the object being iterated over. The Iterator
 * returns MenuItem objects from the collection without exposing the collection's
 * structure.
 */
public class MenuItem {
  String name;
  String description;
  boolean vegetarian;
  double price;

  /**
   * Constructs a new MenuItem.
   *
   * @param name the name of the menu item
   * @param description the description of the menu item
   * @param vegetarian true if the item is vegetarian, false otherwise
   * @param price the price of the menu item
   */
  public MenuItem(String name, String description, boolean vegetarian, double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  /**
   * Returns the name of the menu item.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the description of the menu item.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the price of the menu item.
   *
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Returns whether the item is vegetarian.
   *
   * @return true if vegetarian, false otherwise
   */
  public boolean isVegetarian() {
    return vegetarian;
  }
}
