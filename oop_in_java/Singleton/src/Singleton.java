/**
 * Singleton: Thread-Safe Lazy Initialization.
 *
 * <p>Ensures a class has only one instance and provides a global point of access to it.
 *
 * <p><b>Pattern Role:</b> Singleton.
 *
 * <p>This implementation uses <b>double-checked locking</b> for thread safety and
 * performance:
 * <ol>
 *   <li>First check (unsynced) avoids synchronization overhead after initialization.
 *   <li>Synchronized block ensures only one thread creates the instance.
 *   <li>Second check (synced) prevents race condition.
 *   <li>{@code volatile} keyword ensures visibility of changes across threads.
 * </ol>
 *
 * <p>Use cases: Logger, Configuration Manager, Connection Pool, Cache.
 *
 * <p><b>Note:</b> For modern Java (5+), consider using enum-based Singleton or static
 * holder pattern.
 */
public class Singleton {
  private static volatile Singleton instance;

  /**
   * Returns the global singleton instance.
   *
   * @return the singleton instance
   */
  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}
