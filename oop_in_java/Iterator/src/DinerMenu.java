


public class DinerMenu implements Menu{

	
	static final int MAX_ITEMS = 8;
	int numberOfItems = 0;
	MenuItem[] menuItems = new MenuItem[MAX_ITEMS];
	
	
	public DinerMenu() {
		// TODO Auto-generated constructor stub
		addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato  on whole wheat", true, 2.8999);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.85559);
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.45);
		addItem("Hotdog", "a hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.00058);
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price){
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if(numberOfItems>=MAX_ITEMS) {
			System.err.println("Sorry, Menu is full! can't add item to menu");
		}else {
			
			menuItems[numberOfItems] = menuItem;
			numberOfItems++;
		}
	}
	
	public MenuItem[] getMenuItems(){
		return menuItems;
	}
	public Iterator createIterator(){
		
		return new DinerMenuIterator(menuItems);
	}
}
