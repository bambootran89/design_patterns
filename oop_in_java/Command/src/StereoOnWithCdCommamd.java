
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
