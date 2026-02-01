/** Client demonstration code for the pattern. */
public class client {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

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
