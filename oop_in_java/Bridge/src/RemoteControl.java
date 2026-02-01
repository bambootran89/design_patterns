
public class RemoteControl {
	TV implementor;
	
	public RemoteControl(TV tv) {
		// TODO Auto-generated constructor stub
		implementor =  tv;
	}
	void on(){
		implementor.on();
		
	}
    
	void off() {
		implementor.off();
		
	}
	
	void setChannel(int channel) {
		
		implementor.turnChannel(channel);
	}
}
