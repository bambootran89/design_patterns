/**
 * Refined Abstraction: Concrete Remote.
 *
 * <p>Extends the interface defined by Abstraction with additional features.
 *
 * <p><b>Pattern Role:</b> Refined Abstraction.
 *
 * <p>This class adds higher-level operations (nextChannel, previousChannel) on top of
 * the basic RemoteControl interface. It still delegates to the Implementor (TV) for the
 * actual hardware control.
 *
 * <p>The Bridge pattern allows creating multiple refined abstractions (e.g.,
 * GamingRemote, UniversalRemote) that all work with any TV implementation.
 */
public class ConcreteRemote extends RemoteControl {
  int currentStation = 0;
  static final int MIN = 100;
  static final int MAX = 200;

  public ConcreteRemote(TV tv) {
    super(tv);
    currentStation = MIN;
  }

  void nextChannel() {
    if (currentStation == MAX) {
      System.out.println("Can not set the next channel because it is max");
    } else {
      setChannel(currentStation + 1);
    }
  }

  void previousChannel() {
    if (currentStation == MIN) {
      System.out.println("Can not set the next channel because it is min");
    } else {
      setChannel(currentStation - 1);
    }
  }

  void setChannel(int channel) {
    if (channel <= MAX && channel >= MIN) {
      super.setChannel(channel);
      currentStation = channel;
    } else {
      System.out.println("can not set that channel because it is out of the range from "
          + MIN + " to " + MAX);
    }
  }
}
