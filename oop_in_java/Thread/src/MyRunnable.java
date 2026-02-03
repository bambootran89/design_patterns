/** Thread example using Runnable interface. */
public class MyRunnable implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(this.toString() + " is running");
    }
  }
}
