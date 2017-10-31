
public class SoldState implements State {

	GumballMachine gumBallMachine;
	
	public SoldState(GumballMachine gumb) {
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
		// TODO Auto-generated method stub
		System.out.println("A gumball comes rolling out the slot");
		gumBallMachine.setCount(gumBallMachine.getCount()-1);
		if(gumBallMachine.getCount()==0) {
			System.out.println("Oops, out of gumballs!");
			gumBallMachine.setState(gumBallMachine.getSoldOutState());
		}else{
			gumBallMachine.setState(gumBallMachine.getNoQuarterState());
		}
	}
 
}
