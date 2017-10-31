
public class LeafGraphic implements Graphic {
    private String name;
    public LeafGraphic(String n){
    	name = n;
    }
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("This is a Leaf " + name);
	}

}
