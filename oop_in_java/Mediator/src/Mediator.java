/**
 * Mediator Interface.
 * <p>
 * Defines an interface for communicating with Colleague objects.
 * <p>
 * <b>Pattern Role:</b> Mediator.
 * <p>
 * The Mediator Pattern defines an object that encapsulates how a set of objects
 * interact.
 * It promotes loose coupling by keeping objects from referring to each other
 * explicitly.
 * <p>
 * In this example, the Mediator coordinates interactions between UI components
 * (buttons, labels)
 * so they don't need direct references to each other. When a button is clicked,
 * it notifies
 * the mediator, which then updates the state of other components.
 * <p>
 * This centralizes complex communication logic and reduces dependencies between
 * colleagues.
 */
public interface Mediator {
  void book();

  void view();

  void search();

  void registerView(BtnView v);

  void registerSearch(BtnSearch s);

  void registerBook(BtnBook b);

  void registerDisplay(LblDisplay d);
}
