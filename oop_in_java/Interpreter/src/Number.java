import java.util.Map;

/**
 * Terminal Expression (Number).
 * <p>
 * Represents a constant numerical value in the AST.
 * The interpret operation simply returns the stored number.
 */
public class Number implements Expression {

  private int number;

  public Number(int number) {
    this.number = number;
  }

  @Override
  public int interpret(Map<String, Expression> variables) {
    // TODO Auto-generated method stub
    return number;
  }

  @Override
  public String show() {
    // TODO Auto-generated method stub
    return String.valueOf(number);
  }
}
