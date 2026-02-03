/**
 * Invoker: Remote Control.
 *
 * <p>Asks the command to carry out a request.
 *
 * <p><b>Pattern Role:</b> Invoker.
 *
 * <p>The Invoker holds Command objects and triggers them by calling {@code
 * execute()}. It does NOT know the concrete class of the command or what operation
 * will be performed.
 *
 * <p>In this implementation:
 * <ul>
 *   <li>Commands are stored in arrays ({@code onCommands}, {@code offCommands}).
 *   <li>Buttons are mapped to slots, allowing dynamic configuration.
 *   <li>A "Null Object" pattern (NoCommand) is used to avoid null checks.
 * </ul>
 *
 * <p>This decoupling allows adding new commands without modifying the RemoteControl
 * class.
 */
public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;

  /** Constructor initializes the remote with no commands. */
  public RemoteControl() {
    onCommands = new Command[10];
    offCommands = new Command[10];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 10; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
  }

  /**
   * Helper method for off button push.
   *
   * @param slot slot number
   */
  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
  }

  /**
   * Sets the command for a specific slot.
   *
   * @param slot the slot number
   * @param onCommand the command for the on button
   * @param offCommand the command for the off button
   */
  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public String toString() {
    StringBuffer stringbuff = new StringBuffer();

    stringbuff.append("\n -----------Remote Control ----------\n");
    for (int i = 0; i < onCommands.length; i++) {
      stringbuff.append("[Slot " + i + "] " + onCommands[i].getClass().getName() + "   "
          + offCommands[i].getClass().getName() + " \n");
    }

    return stringbuff.toString();
  }
}
