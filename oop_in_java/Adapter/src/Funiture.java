
public class Funiture implements SolidObject{

	String name;
    public Funiture(String n) {
		// TODO Auto-generated constructor stub
	    name = n;
    }
	@Override
	public void packageObject() {
		// TODO Auto-generated method stub
		System.out.println("Put Funiture " +  name + " it to the van");
	}

}
