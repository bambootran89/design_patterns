public class TestFacade {
  public static void main(String[] args) {
    System.out.println("Testing Java Facade...");
    try {
      Client.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Facade Test Passed!");
  }
}
