public class Client {
	public static Car construct(){		
		ICarBuilder builder = new CarBuilder();
		builder.setColour("Red");
		builder.setWheels(4);
		return builder.getResult();
	}
	public static void main(String[] args) {
		
		construct().printCar();
	}
}
