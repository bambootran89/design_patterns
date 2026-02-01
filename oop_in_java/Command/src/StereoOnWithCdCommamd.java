/**
 * Concrete Command: Stereo On with CD.
 * <p>
 * Encapsulates multiple actions: turn on stereo, set CD mode, set volume.
 * <p>
 * <b>Pattern Role:</b> Concrete Command.
 * <p>
 * Demonstrates how a single command can execute multiple receiver operations,
 * creating a macro-like behavior (composite command pattern).
 */
public class StereoOnWithCdCommamd implements Command {

  Stereo stereo;

  public StereoOnWithCdCommamd(Stereo s) {
    // TODO Auto-generated constructor stub
    stereo = s;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    stereo.on();
    stereo.setCd();
    stereo.setVolume(12);
  }
}
