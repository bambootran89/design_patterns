
public class Book implements SolidObject{
    String name;
    public Book(String n) {
		// TODO Auto-generated constructor stub
	    name = n;
    }
	@Override
	public void packageObject() {
		// TODO Auto-generated method stub
		System.out.println("Put Book " +  name + " it to the van");
	}

}
