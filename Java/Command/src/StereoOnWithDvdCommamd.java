
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
