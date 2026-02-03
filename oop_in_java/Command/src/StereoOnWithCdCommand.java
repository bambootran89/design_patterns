/**
 * Concrete Command: Stereo On with CD.
 *
 * <p>Encapsulates multiple actions: turn on stereo, set CD mode, set volume.
 *
 * <p><b>Pattern Role:</b> Concrete Command.
 *
 * <p>Demonstrates how a single command can execute multiple receiver operations,
 * creating a macro-like behavior (composite command pattern).
 */
public class StereoOnWithCdCommand implements Command {
  Stereo stereo;

  public StereoOnWithCdCommand(Stereo s) {
    stereo = s;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setCd();
    stereo.setVolume(12);
  }
}
