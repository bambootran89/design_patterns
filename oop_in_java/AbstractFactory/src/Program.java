
public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        IGUIFactory factory;
        factory =  new WinFactory();
        
        IButton button = factory.createButtom();
        button.Pain();
        factory = new OSXFactory();
        button  = factory.createButtom();
        button.Pain();
	}

}
