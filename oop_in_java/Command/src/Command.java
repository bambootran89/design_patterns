/**
 * Command Interface.
 *
 * <p>Declares an interface for executing an operation.
 *
 * <p><b>Pattern Role:</b> Command.
 *
 * <p>In the Command Pattern, requests are encapsulated as objects. This allows you to:
 * <ul>
 *   <li>Parameterize objects with operations (store commands in data structures).
 *   <li>Queue or log requests.
 *   <li>Support undoable operations.
 * </ul>
 *
 * <p>The Invoker (e.g., RemoteControl) calls {@code execute()} without knowing the
 * concrete command or the Receiver (e.g., Light, Stereo) details.
 */
public interface Command {
  void execute();
}
