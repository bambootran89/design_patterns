/**
 * Adaptee: Furniture.
 *
 * <p>Represents a solid object (furniture) that can be packaged.
 *
 * <p><b>Pattern Role:</b> Adaptee (implements Target).
 *
 * <p>Like Book, Furniture directly implements the SolidObject interface. Demonstrates
 * objects that conform to the target interface without adaptation.
 */
public class Furniture implements SolidObject {
  String name;

  public Furniture(String n) {
    name = n;
  }

  @Override
  public void packageObject() {
    System.out.println("Put Furniture " + name + " it to the van");
  }
}
