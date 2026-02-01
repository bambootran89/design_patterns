import java.util.Random;

/**
 * Concrete State: Has Quarter State.
 * <p>
 * Represents the state when the gumball machine has a quarter inserted.
 * <p>
 * <b>Pattern Role:</b> Concrete State.
 * <p>
 * Encapsulates behavior for this state including: ejectQuarter (returns to
 * NoQuarter),
 * turnCrank (randomly determines Winner or Sold state), and error handling.
 */
public class HasQuarterState implements State {
  GumballMachine gumBallMachine;
  Random randomWinner = new Random(System.currentTimeMillis());

  public HasQuarterState(GumballMachine gumb) {
    // TODO Auto-generated constructor stub
    gumBallMachine = gumb;
  }

  @Override
  public void insertQuarter() {
    // TODO Auto-generated method stub
    System.out.println("You can't insert another quarter");
  }

  @Override
  public void ejectQuarter() {
    // TODO Auto-generated method stub
    System.out.println("Quarter returned");
    gumBallMachine.setState(gumBallMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    // TODO Auto-generated method stub
    System.out.println("You turned ...");
    int winner = randomWinner.nextInt(10);
    if (winner == 0 && gumBallMachine.getCount() > 1) {
      gumBallMachine.setState(gumBallMachine.getWinnerState());
    } else {
      gumBallMachine.setState(gumBallMachine.getSoldState());
    }
  }

  @Override
  public void dispense() {
    // TODO Auto-generated method stub
    System.out.println("No gumball dispensed");
  }
}
