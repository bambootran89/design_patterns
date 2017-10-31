
public class LightOffCommand implements Command {
    
	Light light;
	public LightOffCommand(Light l) {
		// TODO Auto-generated constructor stub
	    light = l;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.off();
	}

}
