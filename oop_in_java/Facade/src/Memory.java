/**
 * Subsystem: Memory.
 *
 * <p>Memory component hidden behind ComputerFacade.
 *
 * <p><b>Pattern Role:</b> Subsystem.
 */
public class Memory {
  public void load(long position, byte[] data) {
    System.out.println(
        "Memory Loading: to " + position + " with data has length " + data.length);
  }
}
