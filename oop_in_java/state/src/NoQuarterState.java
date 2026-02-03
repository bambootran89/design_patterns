/**
 * Concrete State: No Quarter State.
 * <p>
 * Represents the state when the gumball machine has no quarter inserted.
 * <p>
 * <b>Pattern Role:</b> Concrete State.
 * <p>
 * Encapsulates state-specific behavior. In this state:
 * - {@code insertQuarter()} transitions to HasQuarterState
 * - Other operations display appropriate error messages
 */
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
