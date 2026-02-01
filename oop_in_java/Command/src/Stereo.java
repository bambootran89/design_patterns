/**
 * Receiver: Stereo.
 * <p>
 * Knows how to perform stereo-related operations.
 * <p>
 * <b>Pattern Role:</b> Receiver.
 * <p>
 * This receiver provides multiple operations (on/off, setDvd/Cd/Radio,
 * setVolume)
 * that can be encapsulated into different Command objects, demonstrating how
 * a single Receiver can support multiple commands.
 */
public class Stereo {

  void on() {
    System.out.println("Turn On stereo");
  }

  void off() {
    System.out.println("Turning off stereo ...");
  }

  void setDvd() {
    System.out.println("Selected Dvd function");
  }

  void setCd() {
    System.out.println("Selected Cd function");
  }

  void setRadio() {

    System.out.println("Selected Radio function");
  }

  void setVolume(int volume) {
    System.out.println("volume is set to " + volume);
  }
}
