import java.util.Map;
import java.util.Stack;


public class Evaluator implements Expression{
	private Expression syntaxTree;
	
	public Evaluator(String expression) {
        Stack<Expression> expressionStack = new Stack<Expression>();
        for (String token : expression.split(" ")) {
            if  (token.equals("+")) {
                Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                expressionStack.push( subExpression );
                System.out.println(subExpression + " " + subExpression.show());
            }
            else if (token.equals("-")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new Minus(left, right);
                expressionStack.push( subExpression );
                System.out.println(subExpression + " " + subExpression.show());
            }
            else   {      
            	Expression var =  new Variable(token);
                expressionStack.push( var );
                System.out.println(var + " " + var.show());
            }
        }
        syntaxTree = expressionStack.pop();
        System.out.println(syntaxTree + " " + syntaxTree.show());
        
    }
	@Override
	public int interpret(Map<String, Expression> variables) {
		// TODO Auto-generated method stub
		return syntaxTree.interpret(variables);
	}
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return null;
	}

}
