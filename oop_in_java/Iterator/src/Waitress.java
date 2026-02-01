import java.util.ArrayList;


public class Waitress {

	/**
	 * @param args
	 */
	ArrayList<Menu> menus;
	public Waitress(ArrayList<Menu> menus) {
		// TODO Auto-generated constructor stub
		this.menus =  menus;
	}
     
	void prinMenu(){
		for(Menu ms:menus) {
			Iterator tmp = (Iterator)ms.createIterator();
			System.out.println("\n\n" + tmp.getClass().getName() + "\n\n");
			printMenu(tmp);
		}
	}
	void printMenu(Iterator iterator){
		
		while(iterator.hasNext()){
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem.getName() + ", ");
			System.out.println(menuItem.getPrice() + ", ");
			System.out.println(menuItem.getDescription());
			
		}
	}

}
