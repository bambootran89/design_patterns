
/**
 * Colleague: Book Button.
 * <p>
 * Book button coordinated by Mediator.
 * <p>
 * <b>Pattern Role:</b> Concrete Colleague.
 */
import java.awt.event.ActionListener;
import javax.swing.JButton;

class BtnBook extends JButton implements Command {

  Mediator med;

  BtnBook(ActionListener al, Mediator m) {
    super("Book");
    addActionListener(al);
    med = m;
    med.registerBook(this);
  }

  public void execute() {
    med.book();
  }
}
