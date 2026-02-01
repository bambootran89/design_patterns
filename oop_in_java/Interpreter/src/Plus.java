import java.util.Map;

/**
 * Non-Terminal Expression (Plus).
 * <p>
 * Represents the addition operation. It contains left and right expressions
 * and interprets them recursively, returning the sum of their results.
 */
public class Plus implements Expression {

  Expression leftOperand;
  Expression rightOperand;

  public Plus(Expression left, Expression right) {
    leftOperand = left;
    rightOperand = right;
  }

  @Override
  public int interpret(Map<String, Expression> variables) {
    // TODO Auto-generated method stub
    return leftOperand.interpret(variables) + rightOperand.interpret(variables);
  }

  @Override
  public String show() {
    // TODO Auto-generated method stub
    return leftOperand.toString() + " " + rightOperand.toString();
  }
}
