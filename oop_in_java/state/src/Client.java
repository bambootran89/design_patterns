/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    GumballMachine gumBallMachine = new GumballMachine(5);

    System.out.println(gumBallMachine);

    gumBallMachine.insertQuarter();
    gumBallMachine.turnCrank();

    System.out.println(gumBallMachine);

    gumBallMachine.insertQuarter();
    gumBallMachine.turnCrank();
    gumBallMachine.insertQuarter();
    gumBallMachine.turnCrank();

    System.out.println(gumBallMachine);
  }
}
