
public class NoQuarterState implements State {
	
	GumballMachine gumBallMachine;
	public NoQuarterState(GumballMachine gumb) {
		// TODO Auto-generated constructor stub
		gumBallMachine = gumb;
	}

	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		
		gumBallMachine.setState(gumBallMachine.getHasQuarterState());
		System.out.println("You inserted a quarter");
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("you haven't inserted a quarter");
		
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("you turned but there's no quater");
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("you need to play first");
	}

}
