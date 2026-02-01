
/**
 * Colleague: Search Button.
 * <p>
 * Search button coordinated by Mediator.
 * <p>
 * <b>Pattern Role:</b> Concrete Colleague.
 */
import java.awt.event.ActionListener;
import javax.swing.JButton;

class BtnSearch extends JButton implements Command {

  Mediator med;

  BtnSearch(ActionListener al, Mediator m) {
    super("Search");
    addActionListener(al);
    med = m;
    med.registerSearch(this);
  }

  public void execute() {
    med.search();
  }
}
