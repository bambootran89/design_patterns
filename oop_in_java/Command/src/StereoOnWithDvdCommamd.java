/**
 * Concrete Command: Stereo On with DVD.
 * <p>
 * Composite command: turn on stereo, set DVD mode, set volume.
 * <p>
 * <b>Pattern Role:</b> Concrete Command.
 */
public class StereoOnWithDvdCommamd implements Command {

  Stereo stereo;

  public StereoOnWithDvdCommamd(Stereo s) {
    // TODO Auto-generated constructor stub
    stereo = s;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    stereo.on();
    stereo.setDvd();
    stereo.setVolume(23);
  }
}
