
/**
 * Colleague: View Button.
 * <p>
 * View button coordinated by Mediator.
 * <p>
 * <b>Pattern Role:</b> Concrete Colleague.
 */
import java.awt.event.ActionListener;
import javax.swing.JButton;

class BtnView extends JButton implements Command {

  Mediator med;

  BtnView(ActionListener al, Mediator m) {
    super("View");
    addActionListener(al);
    med = m;
    med.registerView(this);
  }

  public void execute() {
    med.view();
  }
}
