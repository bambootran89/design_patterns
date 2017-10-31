import java.util.ArrayList;


public class PancakeHouseMenu implements Menu{

	

	ArrayList<MenuItem> menuItems= new ArrayList<MenuItem>();
	public PancakeHouseMenu() {
		// TODO Auto-generated constructor stub
		addItem("K&B's Pancake Breakfast", "Pancakes with fried eggs, toast", true, 2.89);
		addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.89);
		addItem("Blueberry Pancake", "Pancakes with fresh blueberries", true, 3.45);
		addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.58);
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
	
	public ArrayList<MenuItem> getMenuItems(){
		return menuItems;
	}
	public Iterator createIterator(){
		
		return new PancakeHouseIterator(menuItems);
	}
}
