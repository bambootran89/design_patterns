/**
 * Visitor Interface.
 * <p>
 * Declares a visit operation for each class of Concrete Element in the object
 * structure.
 * <p>
 * <b>Pattern Role:</b> Visitor.
 * <p>
 * The Visitor Pattern represents an operation to be performed on elements of an
 * object structure.
 * It lets you define a new operation without changing the classes of the
 * elements on which it operates.
 * <p>
 * This uses <b>double dispatch</b>: the element calls
 * {@code visitor.visit(this)},
 * which dispatches to the correct overloaded {@code visit()} method based on
 * the element's type.
 * <p>
 * Benefits:
 * - Easy to add new operations (create new Visitor implementations).
 * - Gathers related operations in one class.
 */
public interface ICarElementVisitor {
  void visit(Wheel wheel);

  void visit(Engine engine);

  void visit(Body body);

  void visit(Car car);
}
