public class TestDecorator {
  public static void main(String[] args) {
    System.out.println("Testing Java Decorator...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Decorator Test Passed!");
  }
}
