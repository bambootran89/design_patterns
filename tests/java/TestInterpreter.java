public class TestInterpreter {
  public static void main(String[] args) {
    System.out.println("Testing Java Interpreter...");
    try {
      InterpreterExample.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Interpreter Test Passed!");
  }
}
