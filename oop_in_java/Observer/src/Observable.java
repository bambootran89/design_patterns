
public interface Observable {
	void addObserver(Observer ob);
	void deleteObserver(Observer ob);
	void notifyObservers();
	void setChanged(Double tem, Double hum, Double pres);
	String getInfo();
}
