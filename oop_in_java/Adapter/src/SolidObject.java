/**
 * Target Interface: SolidObject.
 * <p>
 * Defines the domain-specific interface that Client uses.
 * <p>
 * <b>Pattern Role:</b> Target.
 * <p>
 * In the Adapter Pattern, the Client works with objects conforming to this
 * interface.
 * Adapters convert incompatible interfaces (like Liquid) to match this target
 * interface,
 * allowing them to be used alongside native SolidObject implementations (Book,
 * Furniture).
 */
public interface SolidObject {
  void packageObject();
}
