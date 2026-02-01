/**
 * Implementor: TV.
 * <p>
 * Defines the interface for implementation classes (platform-specific
 * operations).
 * <p>
 * <b>Pattern Role:</b> Implementor.
 * <p>
 * The Implementor provides primitive operations (on, off, turnChannel) that
 * concrete
 * implementors (Sony, RCA) will implement. The Abstraction (RemoteControl)
 * calls
 * these operations without knowing which concrete TV brand it's controlling.
 * <p>
 * This separation allows adding new TV brands without modifying remote control
 * logic.
 */
public abstract class TV {

  void on() {
    System.out.println("Turning On the TV");
  }

  void off() {
    System.out.println("Turning off the TV");
  }

  abstract void turnChannel(int channel);
}
