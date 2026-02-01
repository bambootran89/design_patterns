/**
 * Facade: Computer Facade.
 * <p>
 * Provides a unified interface to a set of interfaces in a subsystem.
 * <p>
 * <b>Pattern Role:</b> Facade.
 * <p>
 * The Facade Pattern simplifies interaction with complex subsystems (CPU,
 * Memory, HardDrive)
 * by providing a higher-level interface. Clients call {@code start()} instead
 * of coordinating
 * multiple low-level operations (freeze, load, jump, execute).
 * <p>
 * Benefits:
 * - Reduces coupling between clients and subsystem classes.
 * - Makes the subsystem easier to use.
 * - Doesn't prevent clients from accessing subsystem classes directly if
 * needed.
 */
public class ComputerFacade {
  private static final long BOOT_ADDRESS = 0x892998;
  private static final long BOOT_SECTOR = 0x87;
  private static final int SECTOR_SIZE = 2;
  private CPU processor;
  private Memory ram;
  private HardDrive hd;

  public ComputerFacade() {
    this.processor = new CPU();
    this.ram = new Memory();
    this.hd = new HardDrive();
  }

  public void start() {
    processor.freeze();
    ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
    processor.jump(BOOT_ADDRESS);
    processor.execute();
  }
}
