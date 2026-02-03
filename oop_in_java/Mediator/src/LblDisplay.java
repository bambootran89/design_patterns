import java.awt.Font;
import javax.swing.JLabel;

/**
 * Colleague: Label Display.
 *
 * <p>Displays information coordinated by Mediator.
 *
 * <p><b>Pattern Role:</b> Concrete Colleague.
 */
class LblDisplay extends JLabel {
  Mediator med;

  LblDisplay(Mediator m) {
    super("Just start...");
    med = m;
    med.registerDisplay(this);
    setFont(new Font("Arial", Font.BOLD, 24));
  }
}
