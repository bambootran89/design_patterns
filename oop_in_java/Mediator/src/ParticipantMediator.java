/**
 * Concrete Mediator: Participant Mediator.
 * <p>
 * Implements cooperative behavior by coordinating Colleague objects.
 * <p>
 * <b>Pattern Role:</b> Concrete Mediator.
 * <p>
 * This class knows and maintains references to all colleague objects (BtnView,
 * BtnSearch, BtnBook, LblDisplay).
 * It implements the coordination logic: when one colleague changes state (e.g.,
 * search button clicked),
 * the mediator updates other colleagues (disables search, enables view/book,
 * updates display).
 * <p>
 * Benefits:
 * - Colleagues remain reusable without tight coupling.
 * - Interaction logic is centralized, making it easier to understand and
 * modify.
 * - Reduces subclassing complexity (colleagues don't need to know about each
 * other).
 */
class ParticipantMediator implements Mediator {

  BtnView btnView;
  BtnSearch btnSearch;
  BtnBook btnBook;
  LblDisplay show;

  // ....
  public void registerView(BtnView v) {
    btnView = v;
  }

  public void registerSearch(BtnSearch s) {
    btnSearch = s;
  }

  public void registerBook(BtnBook b) {
    btnBook = b;
  }

  public void registerDisplay(LblDisplay d) {
    show = d;
  }

  public void book() {
    btnBook.setEnabled(false);
    btnView.setEnabled(true);
    btnSearch.setEnabled(true);
    show.setText("booking...");
  }

  public void view() {
    btnView.setEnabled(false);
    btnSearch.setEnabled(true);
    btnBook.setEnabled(true);
    show.setText("viewing...");
  }

  public void search() {
    btnSearch.setEnabled(false);
    btnView.setEnabled(true);
    btnBook.setEnabled(true);
    show.setText("searching...");
  }
}
