import java.util.Map;

/**
 * Non-Terminal Expression (Minus).
 *
 * <p>Represents the subtraction operation. It contains left and right expressions and
 * interprets them recursively, returning the difference.
 */
public class Minus implements Expression {
  Expression leftOperand;
  Expression rightOperand;

  public Minus(Expression left, Expression right) {
    leftOperand = left;
    rightOperand = right;
  }

  @Override
  public int interpret(Map<String, Expression> variables) {
    return leftOperand.interpret(variables) - rightOperand.interpret(variables);
  }

  @Override
  public String show() {
    return leftOperand.toString() + " " + rightOperand.toString();
  }
}
