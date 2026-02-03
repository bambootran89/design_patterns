/**
 * Subsystem: CPU.
 *
 * <p>CPU component hidden behind ComputerFacade.
 *
 * <p><b>Pattern Role:</b> Subsystem.
 */
public class CPU {
  public void freeze() {
    System.out.println("cpu: freeze");
  }

  public void jump(long position) {
    System.out.println("cpu: jump to " + position);
  }

  public void execute() {
    System.out.println("cpu: execute");
  }
}
