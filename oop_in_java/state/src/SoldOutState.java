/**
 * Concrete State: Sold Out State.
 * <p>
 * Represents the state when the gumball machine is out of gumballs.
 * <p>
 * <b>Pattern Role:</b> Concrete State.
 * <p>
 * All operations display appropriate "sold out" messages. The machine stays
 * in this state until restocked.
 */
public class SoldOutState implements State {
  GumballMachine gumBallMachine;

  public SoldOutState(GumballMachine gumb) {
    // TODO Auto-generated constructor stub
    gumBallMachine = gumb;
  }

  @Override
  public void insertQuarter() {
    // TODO Auto-generated method stub
    System.out.println("You can't insert a quarter, the machine is sold out");
  }

  @Override
  public void ejectQuarter() {
    // TODO Auto-generated method stub
    System.out.println("you can't eject, you haven't inserted a quarter yet");
  }

  @Override
  public void turnCrank() {
    // TODO Auto-generated method stub
    System.out.println("you turned, but there are no gumballs");
  }

  @Override
  public void dispense() {
    // TODO Auto-generated method stub
    System.out.println("No gumball dispensed");
  }
}
