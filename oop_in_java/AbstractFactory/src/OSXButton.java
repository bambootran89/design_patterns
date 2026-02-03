/**
 * Concrete Product (macOS Button).
 *
 * <p>Implements the Button interface with macOS-specific rendering logic.
 *
 * <p><b>Pattern Role:</b> Concrete Product.
 */
public class OSXButton implements IButton {
  @Override
  public void paint() {
    System.out.print("Paint OSXButton"
        + "\n");
  }
}
