/**
 * Concrete Implementor: RCA TV.
 * <p>
 * RCA brand TV implementation.
 * <p>
 * <b>Pattern Role:</b> Concrete Implementor.
 */
public class RCATv extends TV {

  @Override
  void turnChannel(int channel) {
    // TODO Auto-generated method stub
    System.out.println("Start turning channel to " + channel + " for RCA TV");
  }
}
