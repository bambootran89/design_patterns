public class TestAdapter {
  public static void main(String[] args) {
    System.out.println("Testing Java Adapter...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Adapter Test Passed!");
  }
}
