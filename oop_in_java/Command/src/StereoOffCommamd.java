/**
 * Concrete Command: Stereo Off.
 * <p>
 * Encapsulates the action of turning off the stereo.
 * <p>
 * <b>Pattern Role:</b> Concrete Command.
 * <p>
 * Simple command that delegates to {@code stereo.off()}. Paired with
 * StereoOnWithCdCommamd for on/off button functionality.
 */
public class StereoOffCommamd implements Command {

  Stereo stereo;

  public StereoOffCommamd(Stereo s) {
    // TODO Auto-generated constructor stub
    stereo = s;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    stereo.off();
  }
}
