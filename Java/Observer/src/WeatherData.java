import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class WeatherData implements Observable {
    
	List<Observer> observers =  new ArrayList<Observer>();
	Double temperature;
	Double humidity;
	Double pressure;
	
	
	@Override
	public void addObserver(Observer ob ) {
		// TODO Auto-generated method stub
		observers.add(ob);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		Iterator<Observer> iterator = observers.iterator();
		while(iterator.hasNext()) {
			Observer observer =  (Observer) iterator.next();
			observer.update(this);
		}
	
		
	}

	@Override
	public void setChanged(Double tem, Double hum, Double pres) {
		// TODO Auto-generated method stub
		temperature = tem;
		humidity = hum;
		pressure = pres;
		notifyObservers();
	}

	@Override
	public void deleteObserver(Observer ob) {
		// TODO Auto-generated method stub
		observers.remove(ob);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "temperature " + temperature + " humidity " + humidity + " pressure " + pressure;
	}



}
