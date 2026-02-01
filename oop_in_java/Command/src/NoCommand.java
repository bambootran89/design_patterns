/**
 * Null Object: No Command.
 * <p>
 * Implements the Command interface with a "do nothing" behavior.
 * <p>
 * <b>Pattern Role:</b> Null Object.
 * <p>
 * This is an example of the Null Object pattern used within Command pattern.
 * It eliminates the need for null checks in the Invoker (RemoteControl),
 * providing a default "do nothing" command for unassigned buttons.
 */
public class NoCommand implements Command {

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    System.out.println("Do nothing because the command is not set");
  }
}
