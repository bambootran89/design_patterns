
public class RemoteControl {
       Command[] onCommands;
       Command[] offCommands;
       
       public RemoteControl() {
		// TODO Auto-generated constructor stub
	       onCommands =  new Command[10];
	       offCommands =  new Command[10];
       
	       Command noCommand =  new NoCommand();
	       for(int i = 0; i< 10; i++)
	       {
	    	   onCommands[i] =  noCommand;
	    	   offCommands[i] = noCommand;
	    	   
	       }
       }
       public void onButtonWasPushed(int slot){
    	      onCommands[slot].execute();
    	   
       }
       public void offButtonWasPushed(int slot){
    	   
    	     offCommands[slot].execute();
       }
       
       public void setCommand(int slot, Command onCommand, Command offCommand){
    	   onCommands[slot] = onCommand;
    	   offCommands[slot] =  offCommand;
    	   
       }
       public String toString(){
    	   StringBuffer stringbuff =  new StringBuffer();
    	   
    	   stringbuff.append("\n -----------Remote Control ----------\n");
    	   for(int i = 0; i < onCommands.length; i++)
    		   stringbuff.append("[Slot " + i + "] " + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass().getName() + " \n");
    	   
    	   return stringbuff.toString();
       }
       
}
