/**
 * Concrete Factory (macOS).
 * <p>
 * Creates a family of products compatible with macOS (e.g., OSXButton).
 * <p>
 * <b>Pattern Role:</b> Concrete Factory.
 */
public class OSXFactory implements IGUIFactory {

  @Override
  public IButton createButtom() {
    // TODO Auto-generated method stub
    return new OSXButton();
  }
}
