
public class StereoOffCommamd implements Command {
    
	Stereo stereo;
	public StereoOffCommamd(Stereo s) {
		// TODO Auto-generated constructor stub
		stereo = s;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		stereo.off();
	}

}
