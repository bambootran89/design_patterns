/**
 * Adapter: LiquidAdapter.
 *
 * <p>Adapts the Liquid interface to the SolidObject interface.
 *
 * <p><b>Pattern Role:</b> Adapter.
 *
 * <p>This class implements the Target interface (SolidObject) and internally delegates
 * to an Adaptee (Liquid). When {@code packageObject()} is called, it translates this to
 * {@code liquid.packing()}, making Liquid compatible with code expecting SolidObjects.
 *
 * <p>This is the <b>Object Adapter</b> pattern (composition-based).
 */
public class LiquidAdapter implements SolidObject {
  Liquid liquid;

  public LiquidAdapter(Liquid l) {
    liquid = l;
  }

  @Override
  public void packageObject() {
    liquid.packing();
  }
}
