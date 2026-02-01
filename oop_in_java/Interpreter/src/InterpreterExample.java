import java.util.HashMap;
import java.util.Map;

/**
 * Client Application.
 * <p>
 * Demonstrates the usage of the Interpreter Pattern to evaluate a mathematical
 * expression
 * written in Reverse Polish Notation (RPN).
 * <p>
 * <b>Pattern Role:</b> Client.
 * <p>
 * The Client is responsible for:
 * <ol>
 * <li>Creating the Context (the `variables` Map).</li>
 * <li>Parsing the sentence (using `Evaluator`).</li>
 * <li>Invoking the `interpret` operation on the resulting AST.
 * </ol>
 *
 * In this specific example:
 * <ul>
 * <li>Expression: "w x z - +"</li>
 * <li>Context: w=5, x=10, z=42</li>
 * <li>Logic: 5 + (10 - 42)</li>
 * <li>Result: -27</li>
 * </ul>
 */
public class InterpreterExample {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
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
