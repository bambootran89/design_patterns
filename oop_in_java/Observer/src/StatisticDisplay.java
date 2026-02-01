


public class StatisticDisplay implements Observer {



	
	public void display(){
		
		
	}


	@Override
	public void update(Observable ob) {
		// TODO Auto-generated method stub
		System.out.println("Updating for StatisticDisplay with " + ob.getInfo());
	}

}
