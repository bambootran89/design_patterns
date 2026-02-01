/**
 * Menu Item: Data Object.
 * <p>
 * Represents a single menu item with name, description, vegetarian flag, and
 * price.
 * <p>
 * <b>Pattern Role:</b> Element (Data Object).
 * <p>
 * In the Iterator pattern, this is the object being iterated over. The Iterator
 * returns MenuItem objects from the collection without exposing the
 * collection's structure.
 */
public class MenuItem {
  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(String name, String description, boolean vegetarian, double price) {
    // TODO Auto-generated constructor stub
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public String getName() {

    return name;
  }

  public String getDescription() {

    return description;
  }

  public Double getPrice() {

    return price;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }
}
