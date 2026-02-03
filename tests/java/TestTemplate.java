public class TestTemplate {
  public static void main(String[] args) {
    System.out.println("Testing Java Template...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Template Test Passed!");
  }
}
