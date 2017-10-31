import java.util.Map;


public class Variable implements Expression {
	private String name;
    public Variable(String name)       { this.name = name; }
	@Override
	public int interpret(Map<String, Expression> variables) {
		// TODO Auto-generated method stub
		if(null==variables.get(name)) return 0;
		return variables.get(name).interpret(variables);
	}
	@Override
	public String show() {
		// TODO Auto-generated method stub
		return name;
	}

}
