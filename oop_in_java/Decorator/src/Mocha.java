
public class Mocha extends CondimentDecorator{

	Beverage beverage;
	public Mocha(Beverage b) {
		// TODO Auto-generated method stub
		beverage = b;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " Mocha";
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 4.23;
	}

}