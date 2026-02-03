/**
 * Concrete Factory (Windows).
 *
 * <p>Creates a family of products compatible with Windows (e.g., WinButton).
 *
 * <p><b>Pattern Role:</b> Concrete Factory.
 */
public class WinFactory implements IGUIFactory {
  @Override
  public IButton createButton() {
    return new WinButton();
  }
}
