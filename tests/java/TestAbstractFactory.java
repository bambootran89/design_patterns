public class TestAbstractFactory {
  public static void main(String[] args) {
    System.out.println("Testing Java AbstractFactory...");
    try {
      Program.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java AbstractFactory Test Passed!");
  }
}
