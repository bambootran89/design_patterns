/**
 * Concrete Observer: Statistic Display.
 * <p>
 * Receives updates from the Subject (weather data).
 * <p>
 * <b>Pattern Role:</b> Concrete Observer.
 * <p>
 * This observer displays statistical weather data. It implements the
 * {@code update()}
 * method to receive notifications when the Subject's state changes.
 */
public class StatisticDisplay implements Observer {

  public void display() {
  }

  @Override
  public void update(Observable ob) {
    // TODO Auto-generated method stub
    System.out.println("Updating for StatisticDisplay with " + ob.getInfo());
  }
}
