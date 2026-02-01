
public class WinnerState implements State {
    
	GumballMachine gumBallMachine;
	public WinnerState(GumballMachine gumb) {
		// TODO Auto-generated constructor stub
		gumBallMachine = gumb;
	}
	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		System.out.println("Please wait, we're already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("Sorry, you already turned the crank");
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("Turning twice dosen't get you another quarter!");
	}

	@Override
	public void dispense() {
		System.out.println("YOU ARE WINNER! you get two gumballs for your quarter");
		gumBallMachine.releaseBall();
		if(gumBallMachine.getCount() ==0) {
			gumBallMachine.setState(gumBallMachine.getSoldOutState());
			
		}else {
			
			gumBallMachine.releaseBall();
			if(gumBallMachine.getCount()>0){
				gumBallMachine.setState(gumBallMachine.getNoQuarterState());
							
			}else {
				
				System.out.println("Oops, out of gumballs!");
				gumBallMachine.setState(gumBallMachine.getSoldOutState());
			}
		}
	}

}
