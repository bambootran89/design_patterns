
public class ConcreateRemote extends RemoteControl {
    int currentStation = 0;
    final static int MIN = 100;
    final static int MAX = 200;
	public ConcreateRemote(TV tv) {
		super(tv);
		// TODO Auto-generated constructor stub
		currentStation = MIN;
	}
	
	void nextChannel(){
		if(currentStation==MAX) System.out.println("Can not set the next channel because it is max");
		else setChannel(currentStation+ 1);
		
	}
    
	void previousChannel() {
		if(currentStation == MIN) System.out.println("Can not set the next channel because it is min");
		else setChannel(currentStation-1);
	}
	
	void setChannel(int channel){
		if(channel<=MAX && channel>=MIN) {
			super.setChannel(channel);
			currentStation = channel;
		}else {
			
			System.out.println("can not set that channel because it is out of the range from " + MIN + " to " + MAX);
		}
		
	}
}
