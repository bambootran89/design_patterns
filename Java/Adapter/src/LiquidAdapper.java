
public class LiquidAdapper implements SolidObject{

	Liquid liquid;
	public LiquidAdapper(Liquid  l) {
		// TODO Auto-generated constructor stub
		liquid =  l;
	}
	@Override
	public void packageObject() {
		// TODO Auto-generated method stub
		liquid.packing();
	}

}
