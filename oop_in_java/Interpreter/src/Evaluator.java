import java.util.Map;
import java.util.Stack;

/**
 * Expression Parser / Builder.
 *
 * <p>Analyzes a string expression in Reverse Polish Notation (RPN) and constructs the
 * corresponding composite Abstract Syntax Tree (AST).
 *
 * <p><b>Algorithm Detail:</b> The parsing uses a Stack-based approach:
 * <ol>
 *   <li>Tokenize the expression string.
 *   <li>Traverse tokens from left to right.
 *   <li>If a token is an Operator (+, -), pop two expressions from the stack, combine
 * them into a new Non-Terminal Expression (e.g., {@code new Plus(left, right)}), and
 * push it back. <li>If a token is a Variable/Number, create a Terminal Expression and
 * push it. <li>The final item on the stack is the root of the AST.
 * </ol>
 *
 * @see java.util.Stack
 */
public class Evaluator implements Expression {
  private Expression syntaxTree;

  /**
   * Constructs an Evaluator and parses the expression.
   *
   * @param expression the RPN expression string
   */
  public Evaluator(String expression) {
    Stack<Expression> expressionStack = new Stack<Expression>();
    for (String token : expression.split(" ")) {
      if (token.equals("+")) {
        Expression subExpression =
            new Plus(expressionStack.pop(), expressionStack.pop());
        expressionStack.push(subExpression);
        System.out.println(subExpression + " " + subExpression.show());
      } else if (token.equals("-")) {
        // it's necessary remove first the right operand from the stack
        Expression right = expressionStack.pop();
        // ..and after the left one
        Expression left = expressionStack.pop();
        Expression subExpression = new Minus(left, right);
        expressionStack.push(subExpression);
        System.out.println(subExpression + " " + subExpression.show());
      } else {
        Expression var = new Variable(token);
        expressionStack.push(var);
        System.out.println(var + " " + var.show());
      }
    }
    syntaxTree = expressionStack.pop();
    System.out.println(syntaxTree + " " + syntaxTree.show());
  }

  @Override
  public int interpret(Map<String, Expression> variables) {
    return syntaxTree.interpret(variables);
  }

  @Override
  public String show() {
    return null;
  }
}
