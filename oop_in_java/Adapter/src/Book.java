/**
 * Adaptee: Book.
 * <p>
 * Represents a solid object that can be packaged.
 * <p>
 * <b>Pattern Role:</b> Adaptee (implements Target).
 * <p>
 * Book already implements the SolidObject interface, so it works directly
 * with clients expecting that interface. Contrasts with Liquid, which requires
 * an adapter (LiquidAdapter) to work with the same interface.
 */
public class Book implements SolidObject {
  String name;

  public Book(String n) {
    // TODO Auto-generated constructor stub
    name = n;
  }

  @Override
  public void packageObject() {
    // TODO Auto-generated method stub
    System.out.println("Put Book " + name + " it to the van");
  }
}
