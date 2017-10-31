
public class Milk extends CondimentDecorator{

	Beverage beverage;
	public Milk(Beverage b) {
		// TODO Auto-generated method stub
		beverage = b;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " Milk";
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 45.23;
	}

}
