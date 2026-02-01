/**
 * Invoker: Remote Control.
 * <p>
 * Asks the command to carry out a request.
 * <p>
 * <b>Pattern Role:</b> Invoker.
 * <p>
 * The Invoker holds Command objects and triggers them by calling
 * {@code execute()}.
 * It does NOT know the concrete class of the command or what operation will be
 * performed.
 * <p>
 * In this implementation:
 * - Commands are stored in arrays ({@code onCommands}, {@code offCommands}).
 * - Buttons are mapped to slots, allowing dynamic configuration.
 * - A "Null Object" pattern (NoCommand) is used to avoid null checks.
 * <p>
 * This decoupling allows adding new commands without modifying the
 * RemoteControl class.
 */
public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;

  public RemoteControl() {
    // TODO Auto-generated constructor stub
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

  public void offButtonWasPushed(int slot) {

    offCommands[slot].execute();
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public String toString() {
    StringBuffer stringbuff = new StringBuffer();

    stringbuff.append("\n -----------Remote Control ----------\n");
    for (int i = 0; i < onCommands.length; i++)
      stringbuff.append(
          "[Slot "
              + i
              + "] "
              + onCommands[i].getClass().getName()
              + "   "
              + offCommands[i].getClass().getName()
              + " \n");

    return stringbuff.toString();
  }
}
