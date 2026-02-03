/**
 * Concrete Command: Stereo Off.
 *
 * <p>Encapsulates the action of turning off the stereo.
 *
 * <p><b>Pattern Role:</b> Concrete Command.
 *
 * <p>Simple command that delegates to {@code stereo.off()}. Paired with
 * StereoOnWithCdCommand for on/off button functionality.
 */
public class StereoOffCommand implements Command {
  Stereo stereo;

  public StereoOffCommand(Stereo s) {
    stereo = s;
  }

  @Override
  public void execute() {
    stereo.off();
  }
}
