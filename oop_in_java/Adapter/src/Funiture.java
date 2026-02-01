/**
 * Adaptee: Furniture.
 * <p>
 * Represents a solid object (furniture) that can be packaged.
 * <p>
 * <b>Pattern Role:</b> Adaptee (implements Target).
 * <p>
 * Like Book, Furniture directly implements the SolidObject interface.
 * Demonstrates objects that conform to the target interface without adaptation.
 */
public class Funiture implements SolidObject {

  String name;

  public Funiture(String n) {
    // TODO Auto-generated constructor stub
    name = n;
  }

  @Override
  public void packageObject() {
    // TODO Auto-generated method stub
    System.out.println("Put Funiture " + name + " it to the van");
  }
}
