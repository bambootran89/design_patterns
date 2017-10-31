
public class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		// TODO Auto-generated constructor stub
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thin Crust Dough";
		sauce = "Plum Tomato Sauce";
		toppings.add("Shredded Mozzarella Cheese");
		toppings.add("Shredded " + dough);
		toppings.add("Shredded " + sauce);
	}
	void cut(){
		System.out.println("Cutting the pizza into square slices");
	}
}
