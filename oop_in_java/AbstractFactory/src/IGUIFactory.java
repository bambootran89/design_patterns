/**
 * Abstract Factory Interface.
 * <p>
 * Declares an interface for operations that create abstract product objects.
 * <p>
 * <b>Pattern Role:</b> Abstract Factory.
 * <p>
 * Concrete factories (WinFactory, OSXFactory) implement this interface to
 * create
 * families of related objects (Buttons, Checkboxes) without specifying their
 * concrete classes.
 */
public interface IGUIFactory {
  public IButton createButtom();
}
