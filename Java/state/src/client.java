
public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GumballMachine gumBallMachine =  new GumballMachine(5);
        
        System.out.println(gumBallMachine);
        
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        
        System.out.println(gumBallMachine);
        
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        
        System.out.println(gumBallMachine);
	}

}
