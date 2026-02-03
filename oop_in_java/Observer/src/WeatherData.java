import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Concrete Subject: Weather Data Station.
 *
 * <p>Implement the Observable interface to broadcast weather updates.
 *
 * <p><b>Pattern Role:</b> Concrete Subject.
 *
 * <p>This class holds the master state (temperature, humidity, pressure). When
 * `setChanged` is called (simulating new sensor data), it iterates through the list of
 * registered observers and pushes the new state to them via the {@code update()}
 * method.
 *
 * <p>This illustrates the **Push Model** of the Observer pattern, where the Subject
 * sends detailed data directly in the active notification.
 */
public class WeatherData implements Observable {
  List<Observer> observers = new ArrayList<Observer>();
  Double temperature;
  Double humidity;
  Double pressure;

  @Override
  public void addObserver(Observer ob) {
    observers.add(ob);
  }

  @Override
  public void notifyObservers() {
    Iterator<Observer> iterator = observers.iterator();
    while (iterator.hasNext()) {
      Observer observer = (Observer) iterator.next();
      observer.update(this);
    }
  }

  @Override
  public void setChanged(Double tem, Double hum, Double pres) {
    temperature = tem;
    humidity = hum;
    pressure = pres;
    notifyObservers();
  }

  @Override
  public void deleteObserver(Observer ob) {
    observers.remove(ob);
  }

  @Override
  public String getInfo() {
    return "temperature " + temperature + " humidity " + humidity + " pressure "
        + pressure;
  }
}
