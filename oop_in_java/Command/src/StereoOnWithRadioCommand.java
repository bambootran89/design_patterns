/**
 * Concrete Command: Stereo On with Radio.
 *
 * <p>Composite command: turn on stereo, set Radio mode, set volume.
 *
 * <p><b>Pattern Role:</b> Concrete Command.
 */
public class StereoOnWithRadioCommand implements Command {
  Stereo stereo;

  public StereoOnWithRadioCommand(Stereo s) {
    stereo = s;
  }

  @Override
  public void execute() {
    stereo.on();
    stereo.setRadio();
    stereo.setVolume(23);
  }
}
