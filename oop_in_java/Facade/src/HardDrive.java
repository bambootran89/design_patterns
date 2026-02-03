/**
 * Subsystem: Hard Drive.
 *
 * <p>Hard drive component hidden behind ComputerFacade.
 *
 * <p><b>Pattern Role:</b> Subsystem.
 */
public class HardDrive {
  public byte[] read(long lba, int size) {
    // using literals or Byte.valueOf instead of deprecated new Byte()
    byte[] data = {(byte) 0x01, (byte) 0x11};
    System.out.println("HardDrive: reading");
    return data;
  }
}
