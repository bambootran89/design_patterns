

public class Soy extends CondimentDecorator{

	Beverage beverage;
	public Soy(Beverage b) {
		// TODO Auto-generated method stub
		beverage = b;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " Soy";
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 123.23;
	}

}