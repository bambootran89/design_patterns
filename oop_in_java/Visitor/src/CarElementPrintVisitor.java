/**
 * Concrete Visitor: Print Visitor.
 * <p>
 * Implements each operation declared in the Visitor interface.
 * <p>
 * <b>Pattern Role:</b> Concrete Visitor.
 * <p>
 * This visitor implements a specific operation (printing) across all element
 * types.
 * Each {@code visit()} method defines the operation for one element type
 * (Wheel, Engine, Body, Car).
 * <p>
 * Adding a new operation (e.g., CarElementDoVisitor for performing actions)
 * requires
 * creating a new Concrete Visitor, not modifying element classes.
 * <p>
 * This adheres to the Open-Closed Principle for adding operations.
 */
public class CarElementPrintVisitor implements ICarElementVisitor {
  public void visit(Wheel wheel) {
    System.out.println("Visiting " + wheel.getName() + " wheel");
  }

  public void visit(Engine engine) {
    System.out.println("Visiting engine");
  }

  public void visit(Body body) {
    System.out.println("Visiting body");
  }

  public void visit(Car car) {
    System.out.println("Visiting car");
  }
}
