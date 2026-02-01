/**
 * Element Interface.
 * <p>
 * Declares an accept operation that takes a visitor as an argument.
 * <p>
 * <b>Pattern Role:</b> Element.
 * <p>
 * Each element in the object structure implements
 * {@code accept(ICarElementVisitor visitor)}.
 * The implementation typically calls {@code visitor.visit(this)}, passing
 * itself to the visitor.
 * <p>
 * This enables the visitor to perform operations on the element without the
 * element
 * needing to know what those operations are.
 */
public interface ICarElement {
  void accept(ICarElementVisitor visitor);
}
