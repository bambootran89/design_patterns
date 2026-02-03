/** Client: demonstrates the AbstractFactory pattern. */
public class Program {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    IGUIFactory factory;
    factory = new WinFactory();

    IButton button = factory.createButton();
    button.paint();
    factory = new OSXFactory();
    button = factory.createButton();
    button.paint();
  }
}
