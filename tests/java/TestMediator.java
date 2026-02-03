public class TestMediator {
  public static void main(String[] args) {
    System.out.println("Testing Java Mediator...");
    try {
      MediatorDemo.main(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Java Mediator Test Passed!");
  }
}
