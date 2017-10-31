import java.util.ArrayList;


public class PancakeHouseIterator implements Iterator {
    ArrayList<MenuItem> items;
	java.util.Iterator<MenuItem> iterator;
    public PancakeHouseIterator(ArrayList<MenuItem> items) {
		// TODO Auto-generated constructor stub
    	this.items = items;
    	iterator =  items.iterator();
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return iterator.hasNext();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub		
        
		return iterator.next();
	}

}
