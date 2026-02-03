/**
 * Concrete Product (Windows Button).
 *
 * <p>Implements the Button interface with Windows-specific rendering logic.
 *
 * <p><b>Pattern Role:</b> Concrete Product.
 */
public class WinButton implements IButton {
  @Override
  public void paint() {
    System.out.print("Paint WinButton"
        + "\n");
  }
}
