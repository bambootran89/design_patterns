
public abstract class Beverage {

	/**
	 * @param args
	 */
	protected String description = "Unknow";
	public String getDescription(){
		return description;
	}
	
	public abstract Double cost();

}
