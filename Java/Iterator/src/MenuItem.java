
public class MenuItem {
	String name;
	String description;
	boolean vegetarian;
	double price;
	public MenuItem(String name, String description, boolean vegetarian, double price) {
		// TODO Auto-generated constructor stub
		this.name =  name;
		this.description =  description;
		this.vegetarian =  vegetarian;
		this.price = price;
	}
	
	public String getName(){
		
		return name;
		
	}
    public String getDescription(){
    	
    	return description;
    }
    
    public Double getPrice(){
    	
    	return price;
    }
    
    public boolean isVegetarian(){
    	return vegetarian;
    }
}

