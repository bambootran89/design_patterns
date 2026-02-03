/**
 * Concrete Implementor: Sony TV.
 *
 * <p>Sony brand TV implementation.
 *
 * <p><b>Pattern Role:</b> Concrete Implementor.
 */
public class Sony extends TV {
  @Override
  void turnChannel(int channel) {
    System.out.println("Start turning channel to " + channel + " for SONY TV");
  }
}
