import java.util.HashMap;
import java.util.Map;

/**
 * Client Application.
 *
 * <p>Demonstrates the usage of the Interpreter Pattern to evaluate a mathematical
 * expression written in Reverse Polish Notation (RPN).
 *
 * <p><b>Pattern Role:</b> Client.
 *
 * <p>The Client is responsible for:
 * <ol>
 *   <li>Creating the Context (the {@code variables} Map).
 *   <li>Parsing the sentence (using {@code Evaluator}).
 *   <li>Invoking the {@code interpret} operation on the resulting AST.
 * </ol>
 *
 * <p>In this specific example:
 * <ul>
 *   <li>Expression: "w x z - +"
 *   <li>Context: w=5, x=10, z=42
 *   <li>Logic: 5 + (10 - 42)
 *   <li>Result: -27
 * </ul>
 */
public class InterpreterExample {
  /**
   * Main entry point.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    String expression = "w x z - +";
    Evaluator sentence = new Evaluator(expression);
    Map<String, Expression> variables = new HashMap<String, Expression>();
    variables.put("w", new Number(5));
    variables.put("x", new Number(10));
    variables.put("z", new Number(42));
    int result = sentence.interpret(variables);
    System.out.println(result);
  }
}
