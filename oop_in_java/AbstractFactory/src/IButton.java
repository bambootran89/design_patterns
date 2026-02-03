/**
 * Abstract Product Interface (Button).
 *
 * <p>Declares the interface for a type of product object.
 *
 * <p><b>Pattern Role:</b> Abstract Product.
 *
 * <p>Concrete Button implementations (WinButton, OSXButton) will define the specific
 * behavior (painting) for their respective operating systems.
 */
public interface IButton {
  public void paint();
}
