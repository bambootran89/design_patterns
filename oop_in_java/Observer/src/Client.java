/** Client demonstration code for the pattern. */
public class Client {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Observable weatherData = new WeatherData();
    Observer ob1 = new ForecastDisplay();
    Observer ob2 = new StatisticDisplay();
    Observer ob3 = new GeneralDisplay();

    weatherData.addObserver(ob1);
    weatherData.addObserver(ob2);
    weatherData.addObserver(ob3);

    weatherData.setChanged(34.0, 89.78, 1.34);
  }
}
