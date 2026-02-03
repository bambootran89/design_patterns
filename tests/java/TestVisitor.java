public class TestVisitor {
  public static void main(String[] args) {
    System.out.println("Testing Java Visitor...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Visitor Test Passed!");
  }
}
