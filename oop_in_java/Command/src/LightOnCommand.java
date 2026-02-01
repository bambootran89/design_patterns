
public class LightOnCommand implements Command {
    
	Light light;
	public LightOnCommand(Light l) {
		// TODO Auto-generated constructor stub
	    light = l;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.on();
	}

}
