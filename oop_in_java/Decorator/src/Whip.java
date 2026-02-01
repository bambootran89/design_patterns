

public class Whip extends CondimentDecorator{

	Beverage beverage;
	public Whip(Beverage b) {
		// TODO Auto-generated method stub
		beverage = b;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " Whip";
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 23.23;
	}

}