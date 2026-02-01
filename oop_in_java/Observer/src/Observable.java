/**
 * Observable (Subject) Interface.
 *
 * <p>
 * Defines the contract for objects that can have observers notified of changes.
 *
 * <p>
 * <b>Pattern Role:</b> Subject.
 *
 * <p>
 * In the Observer Pattern, the Subject tracks a dynamic list of Observers and
 * notifies
 * them automatically of any state changes. This decouples the core business
 * logic (Subject)
 * from the dependent view logic (Observers).
 */
public interface Observable {
  void addObserver(Observer ob);

  void deleteObserver(Observer ob);

  void notifyObservers();

  void setChanged(Double tem, Double hum, Double pres);

  String getInfo();
}
