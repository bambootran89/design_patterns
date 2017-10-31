
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
