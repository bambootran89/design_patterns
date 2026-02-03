/**
 * Observer Interface.
 *
 * <p>Defines the update interface for objects that should be notified of changes in a
 * Subject.
 *
 * <p><b>Pattern Role:</b> Observer.
 *
 * <p>All concrete observers (e.g., Displays, Loggers) implement this interface. When
 * {@code notifyObservers()} is called on the Subject, the {@code update} method is
 * triggered here, keeping the state synchronized.
 */
public interface Observer {
  void update(Observable ob);
}
