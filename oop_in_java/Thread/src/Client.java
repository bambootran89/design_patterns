/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    MyThread myThread1 = new MyThread();
    myThread1.start();
    MyThread myThread2 = new MyThread();
    myThread2.start();

    Thread thread = new Thread(new MyRunnable());
    thread.start();
  }
}
