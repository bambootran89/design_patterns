
public class GumballMachine {
	State soldState;
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State winnerState;
	State state = soldOutState;
	
	int count = 0;
	public GumballMachine(int numberGumballs) {
		
		soldState = new SoldState(this);
		soldOutState =  new SoldOutState(this);
		noQuarterState =  new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		winnerState =  new WinnerState(this);
		count = numberGumballs;
		if(count > 0) {
			state= noQuarterState;
			
		}
	}
	
	State getNoQuarterState() { return noQuarterState;}
	State getHasQuarterState(){ return hasQuarterState;}
	State getSoldOutState(){ return soldOutState;}
	State getSoldState(){ return soldState;}
	State getWinnerState() {return winnerState;}
	int getCount() {return count;}
	void setCount(int c) {count =c;}
	public void insertQuarter(){
		state.insertQuarter();
	}
	
	public void ejectQuarter(){
		state.ejectQuarter();
		
	}
	
	public void turnCrank(){
		state.turnCrank();
		state.dispense();
	}
	void setState(State state){
		
		this.state = state;
	}
	void releaseBall(){
		
		System.out.println("A gumball comes rolling out the slot ...");
		if(count!=0) {
			
			count--;
		}
		
	}
	
}
