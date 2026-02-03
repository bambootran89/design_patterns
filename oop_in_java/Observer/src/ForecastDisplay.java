/**
 * Concrete Observer: Forecast Display.
 *
 * <p>Displays weather forecast information.
 *
 * <p><b>Pattern Role:</b> Concrete Observer.
 */
public class ForecastDisplay implements Observer {
  public void display() {}

  @Override
  public void update(Observable ob) {
    // TODO Auto-generated method stub
    System.out.println("Updating for ForecastDisplay with " + ob.getInfo());
  }
}
