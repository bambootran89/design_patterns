
public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("cheese"))
			return new NYStyleCheesePizza();
		else return null;
	}

}
