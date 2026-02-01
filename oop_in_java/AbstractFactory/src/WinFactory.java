
public class WinFactory implements IGUIFactory{

	@Override
	public IButton createButtom() {
		// TODO Auto-generated method stub
		return new WinButton();
	}

}
