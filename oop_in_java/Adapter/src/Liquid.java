/**
 * Adaptee: Liquid.
 *
 * <p>An existing class with an incompatible interface.
 *
 * <p><b>Pattern Role:</b> Adaptee.
 *
 * <p>Liquid has a {@code packing()} method, but the client code expects {@code
 * packageObject()}. The Adapter (LiquidAdapter) bridges this gap, translating calls
 * from the Target interface to the Adaptee's interface.
 */
public class Liquid {
  private String name;

  public Liquid(String name) {
    this.name = name;
  }

  public void packing() {
    System.out.println(
        "Pouring the liquid " + name + " into a container for packaging into the van");
  }
}
