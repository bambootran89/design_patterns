/**
 * Concrete State: Sold.
 * <p>
 * Represents the state where a gumball is being dispensed.
 * <p>
 * <b>Pattern Role:</b> Concrete State.
 * <p>
 * When the machine is in the SoldState:
 * - Trying to insert or eject a quarter is invalid (prints error message).
 * - The {@code dispense()} method decrements the gumball count and transitions
 * to either NoQuarterState (if gumballs remain) or SoldOutState (if empty).
 * <p>
 * This encapsulates the state-specific behavior and transition logic for the
 * "Sold" state.
 */
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
    gumBallMachine.setCount(gumBallMachine.getCount() - 1);
    if (gumBallMachine.getCount() == 0) {
      System.out.println("Oops, out of gumballs!");
      gumBallMachine.setState(gumBallMachine.getSoldOutState());
    } else {
      gumBallMachine.setState(gumBallMachine.getNoQuarterState());
    }
  }
}
