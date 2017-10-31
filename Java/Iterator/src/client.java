import java.util.ArrayList;


public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PancakeHouseMenu pancakeHouseMenu =  new PancakeHouseMenu();
        DinerMenu dinerMenu =  new DinerMenu();
        
        ArrayList<Menu> menus =  new ArrayList<Menu>();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(pancakeHouseMenu);
        
        Waitress waitress = new Waitress(menus);
        
        waitress.prinMenu();
	}

}
