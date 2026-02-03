/**
 * Concrete Command: Light On.
 *
 * <p>Defines a binding between a Receiver (Light) and an action (on).
 *
 * <p><b>Pattern Role:</b> Concrete Command.
 *
 * <p>This class implements the Command interface and invokes the corresponding
 * operation(s) on the Receiver. It maintains a reference to the Receiver object and
 * knows which method to call
 * ({@code light.on()}).
 *
 * <p>The Command Pattern decouples the Invoker (RemoteControl) from the Receiver
 * (Light), allowing dynamic binding of actions to buttons.
 */
public class LightOnCommand implements Command {
  Light light;

  public LightOnCommand(Light l) {
    // TODO Auto-generated constructor stub
    light = l;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    light.on();
  }
}
