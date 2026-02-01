/**
 * Command Interface.
 * <p>
 * Declares an interface for executing an operation.
 * <p>
 * <b>Pattern Role:</b> Command.
 * <p>
 * In the Command Pattern, requests are encapsulated as objects. This allows you
 * to:
 * - Parameterize objects with operations (store commands in data structures).
 * - Queue or log requests.
 * - Support undoable operations.
 * <p>
 * The Invoker (e.g., RemoteControl) calls {@code execute()} without knowing the
 * concrete command
 * or the Receiver (e.g., Light, Stereo) details.
 */
public interface Command {
  void execute();
}
