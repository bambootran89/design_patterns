/**
 * Concrete Observer: General Display.
 * <p>
 * Displays general weather information.
 * <p>
 * <b>Pattern Role:</b> Concrete Observer.
 */
public class GeneralDisplay implements Observer {

  public void display() {
  }

  @Override
  public void update(Observable ob) {
    // TODO Auto-generated method stub
    System.out.println("Updating for GeneralDisplay with " + ob.getInfo());
  }
}
