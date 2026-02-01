import java.util.Map;

/**
 * Abstract Expression (Interface).
 * <p>
 * Defines the `interpret` method that is common to all nodes in the Abstract
 * Syntax Tree (AST).
 * <p>
 * <b>Pattern Role:</b> Abstract Expression.
 * <p>
 * In the Interpreter pattern, the grammar of the language is defined by the
 * relationships
 * between these expressions. Both Terminal (leaf) and Non-Terminal (composite)
 * nodes
 * implement this interface to allow recursive evaluation of the sentence.
 *
 * @see Number
 * @see Plus
 * @see Minus
 */
public interface Expression {
  public int interpret(Map<String, Expression> variables);

  public String show();
}
