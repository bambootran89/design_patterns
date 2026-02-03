public class TestBridge {
  public static void main(String[] args) {
    System.out.println("Testing Java Bridge...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Bridge Test Passed!");
  }
}
