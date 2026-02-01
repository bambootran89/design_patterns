/**
 * Concrete Command: Stereo On with Radio.
 * <p>
 * Composite command: turn on stereo, set Radio mode, set volume.
 * <p>
 * <b>Pattern Role:</b> Concrete Command.
 */
public class StereoOnWithRadioCommamd implements Command {

  Stereo stereo;

  public StereoOnWithRadioCommamd(Stereo s) {
    // TODO Auto-generated constructor stub
    stereo = s;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    stereo.on();
    stereo.setRadio();
    stereo.setVolume(23);
  }
}
