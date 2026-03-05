package shapes;

public abstract class OctagonalPrism extends Shape
{
	private double edgeLenght;
	
	public OctagonalPrism(double height, double edgeLength) {
		super(height);
		this.edgeLenght = edgeLength;
	}
	@Override
	 public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(edgeLenght, 2);
	}
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
}
