import java.util.Map;

/**
 * Terminal Expression (Variable).
 *
 * <p>Represents a variable in the expression key (e.g. "x", "y"). The interpret
 * operation retrieves the variable's value from the context map.
 */
public class Variable implements Expression {
  private String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public int interpret(Map<String, Expression> variables) {
    if (null == variables.get(name)) {
      return 0;
    }
    return variables.get(name).interpret(variables);
  }

  @Override
  public String show() {
    return name;
  }
}
