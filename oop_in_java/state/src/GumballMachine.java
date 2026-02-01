/**
 * Context: Gumball Machine.
 * <p>
 * Maintains a reference to the current State and delegates all requests to it.
 * <p>
 * <b>Pattern Role:</b> Context.
 * <p>
 * The GumballMachine does not contain conditional logic for state-specific
 * behavior.
 * Instead, it holds instances of all possible states and delegates method calls
 * (insertQuarter, turnCrank, etc.) to the current state object.
 * <p>
 * States can call {@code setState()} to transition the machine to a new state,
 * creating a clear state machine with explicit transitions.
 */
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
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    winnerState = new WinnerState(this);
    count = numberGumballs;
    if (count > 0) {
      state = noQuarterState;
    }
  }

  State getNoQuarterState() {
    return noQuarterState;
  }

  State getHasQuarterState() {
    return hasQuarterState;
  }

  State getSoldOutState() {
    return soldOutState;
  }

  State getSoldState() {
    return soldState;
  }

  State getWinnerState() {
    return winnerState;
  }

  int getCount() {
    return count;
  }

  void setCount(int c) {
    count = c;
  }

  public void insertQuarter() {
    state.insertQuarter();
  }

  public void ejectQuarter() {
    state.ejectQuarter();
  }

  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  void setState(State state) {

    this.state = state;
  }

  void releaseBall() {

    System.out.println("A gumball comes rolling out the slot ...");
    if (count != 0) {

      count--;
    }
  }
}
