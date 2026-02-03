/**
 * Command Interface (Mediator Pattern Context).
 *
 * <p>Defines the interface for colleague commands in the Mediator pattern.
 *
 * <p><b>Note:</b> This is a separate Command interface used within the Mediator
 * pattern, not to be confused with the Command pattern's Command interface.
 */
public interface Command {
  void execute();
}
