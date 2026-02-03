import java.util.ArrayList;
import java.util.List;

/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    List<SolidObject> list = new ArrayList<SolidObject>();
    Book book1 = new Book("Histories");
    list.add(book1);
    Book book2 = new Book("Literature");
    list.add(book2);
    Book book3 = new Book("Physics");
    list.add(book3);

    Furniture furniture1 = new Furniture("Tables");
    list.add(furniture1);
    Furniture furniture2 = new Furniture("Cookers");
    list.add(furniture2);

    Liquid liquid1 = new Liquid("Water");
    Liquid liquid2 = new Liquid("Fuel");

    LiquidAdapter liquidAdapter1 = new LiquidAdapter(liquid1);
    list.add(liquidAdapter1);
    LiquidAdapter liquidAdapter2 = new LiquidAdapter(liquid2);
    list.add(liquidAdapter2);

    for (SolidObject solidObject : list) {
      solidObject.packageObject();
    }
  }
}
