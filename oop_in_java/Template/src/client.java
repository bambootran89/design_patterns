
public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeaWithHook teaWithHook =  new TeaWithHook();
		
		CoffeeWithHook coffeeWithHook =  new CoffeeWithHook();
		
		System.out.println("Making tea ...");
		teaWithHook.prepareRecipe();
		System.out.println("Making coffee ..");
		coffeeWithHook.prepareRecipe();
	}

}
