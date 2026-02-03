import java.util.ArrayList;

/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();

    ArrayList<Menu> menus = new ArrayList<Menu>();
    menus.add(pancakeHouseMenu);
    menus.add(dinerMenu);
    menus.add(pancakeHouseMenu);
    menus.add(dinerMenu);
    menus.add(pancakeHouseMenu);

    Waitress waitress = new Waitress(menus);

    waitress.prinMenu();
  }
}
