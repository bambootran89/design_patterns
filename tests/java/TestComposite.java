public class TestComposite {
  public static void main(String[] args) {
    System.out.println("Testing Java Composite...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Composite Test Passed!");
  }
}
