
public class HappyHourStrategy implements BillingStrategy {

	@Override
	public double getActPrice(double rawPrice) {
		// TODO Auto-generated method stub
		return rawPrice*0.5;
	}

}
