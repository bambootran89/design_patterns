import java.util.ArrayList;
import java.util.List;


public class CompositeGraphic implements Graphic {
	private String name;
	
    private List<Graphic> childGraphics = new ArrayList<Graphic>();
    
    public CompositeGraphic(String n) {
		// TODO Auto-generated constructor stub
    	name = n;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("This is CompositeGraphic " + name );
		for(Graphic graphic:childGraphics){
			graphic.print();
			
		}
		
	}
	public void add(Graphic graphic){
		childGraphics.add(graphic);
	}
	public void remove(Graphic graphic) {
		childGraphics.remove(graphic);
	}

}
