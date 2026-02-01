import java.util.ArrayList;
import java.util.List;

/** Client demonstration code for the pattern. */
public class client {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<SolidObject> lists = new ArrayList<SolidObject>();
    Book book1 = new Book("Histories");
    lists.add(book1);
    Book book2 = new Book("literatures");
    lists.add(book2);
    Book book3 = new Book("Physics");
    lists.add(book3);

    Funiture funiture1 = new Funiture("Tables");
    lists.add(funiture1);
    Funiture funiture2 = new Funiture("Cookers");
    lists.add(funiture2);

    Liquid liquid1 = new Liquid("Water");
    Liquid liquid2 = new Liquid("Fuel");

    LiquidAdapper liqAdaper1 = new LiquidAdapper(liquid1);
    lists.add(liqAdaper1);
    LiquidAdapper liqAdaper2 = new LiquidAdapper(liquid2);
    lists.add(liqAdaper2);

    for (SolidObject solidObjects : lists) {
      solidObjects.packageObject();
    }
  }
}
