/**
 * Adapter: LiquidAdapter.
 * <p>
 * Adapts the Liquid interface to the SolidObject interface.
 * <p>
 * <b>Pattern Role:</b> Adapter.
 * <p>
 * This class implements the Target interface (SolidObject) and internally
 * delegates to an Adaptee (Liquid). When {@code packageObject()} is called,
 * it translates this to {@code liquid.packing()}, making Liquid compatible
 * with code expecting SolidObjects.
 * <p>
 * This is the <b>Object Adapter</b> pattern (composition-based).
 */
public class LiquidAdapper implements SolidObject {

  Liquid liquid;

  public LiquidAdapper(Liquid l) {
    // TODO Auto-generated constructor stub
    liquid = l;
  }

  @Override
  public void packageObject() {
    // TODO Auto-generated method stub
    liquid.packing();
  }
}
