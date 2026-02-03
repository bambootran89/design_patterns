/**
 * Concrete Command: Light Off.
 *
 * <p>Encapsulates the action of turning off a light.
 *
 * <p><b>Pattern Role:</b> Concrete Command.
 *
 * <p>Binds the Light receiver to the {@code off()} action. This command can be assigned
 * to any button on the remote control, demonstrating the Command pattern's flexibility.
 */
public class LightOffCommand implements Command {
  Light light;

  public LightOffCommand(Light l) {
    // TODO Auto-generated constructor stub
    light = l;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    light.off();
  }
}
