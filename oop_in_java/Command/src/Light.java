/**
 * Receiver: Light.
 *
 * <p>Knows how to perform the operations associated with carrying out a request.
 *
 * <p><b>Pattern Role:</b> Receiver.
 *
 * <p>In the Command pattern, the Receiver is the object that actually performs the
 * work. Commands delegate to receivers ({@code light.on()}, {@code light.off()}).
 */
public class Light {
  void on() {
    System.out.println("Light is turned on ...");
  }

  void off() {
    System.out.println("Light is turned off ...");
  }
}
