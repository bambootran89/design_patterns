/**
 * State Interface.
 *
 * <p>Defines the operations available in each state of the Gumball Machine.
 *
 * <p><b>Pattern Role:</b> State.
 *
 * <p>In the State Pattern, the Context (GumballMachine) delegates state-specific
 * behavior to the current State object. Each Concrete State (SoldState, NoQuarterState,
 * etc.) implements this interface to define how the machine responds to events in that
 * particular state. This eliminates large conditional statements and makes state
 * transitions explicit.
 */
public interface State {
  void insertQuarter();

  void ejectQuarter();

  void turnCrank();

  void dispense();
}
