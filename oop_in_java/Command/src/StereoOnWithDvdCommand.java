/**
 * Concrete Command: Stereo On with DVD.
 *
 * <p>Composite command: turn on stereo, set DVD mode, set volume.
 *
 * <p><b>Pattern Role:</b> Concrete Command.
 */
public class StereoOnWithDvdCommand implements Command {
  Stereo stereo;

  public StereoOnWithDvdCommand(Stereo s) {
    stereo = s;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setDvd();
    stereo.setVolume(23);
  }
}
