
public class CarBuilder implements ICarBuilder {

	private Car car;
	public CarBuilder(){
		car = new Car();
	}
	@Override
	public void setColour(String colour) {
		// TODO Auto-generated method stub
		car.Colours = colour;
		
	}

	@Override
	public void setWheels(int count) {
		// TODO Auto-generated method stub
		car.Wheels = count;
	}

	@Override
	public Car getResult() {
		// TODO Auto-generated method stub
		return this.car;
	}

}
