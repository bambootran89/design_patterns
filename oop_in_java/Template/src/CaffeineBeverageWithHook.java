
public abstract class CaffeineBeverageWithHook {
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCodiments()) {
			addCondiments();
		}
		
	}

	private void pourInCup() {
		// TODO Auto-generated method stub
		System.out.println("Boiling water");
	}

	protected abstract void addCondiments() ;

	protected boolean customerWantsCodiments() {
		// TODO Auto-generated method stub
		return true;
	}

	protected abstract void brew();

	private void boilWater() {
		// TODO Auto-generated method stub
		System.out.println("Pouring into cup");
	}
}
