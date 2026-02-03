/**
 * Abstraction: Remote Control.
 *
 * <p>Defines the abstraction's interface and maintains a reference to an Implementor.
 *
 * <p><b>Pattern Role:</b> Abstraction.
 *
 * <p>In the Bridge Pattern, the Abstraction defines high-level control logic (on, off,
 * setChannel) and delegates implementation details to the Implementor (TV). This
 * decoupling allows the abstraction and implementation to vary independently.
 *
 * <p>For example, you can have different remote controls (universal, specialized)
 * working with different TV brands (Sony, RCA) without creating a Cartesian product of
 * classes.
 */
public class RemoteControl {
  TV implementor;

  public RemoteControl(TV tv) {
    implementor = tv;
  }

  void on() {
    implementor.on();
  }

  void off() {
    implementor.off();
  }

  void setChannel(int channel) {
    implementor.turnChannel(channel);
  }
}
