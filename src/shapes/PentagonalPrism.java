package shapes;

public class PentagonalPrism extends Shape
{
	private double edgeLength;
	public PentagonalPrism( double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}
	@Override
	public double getBaseArea() {
		double angleInRadians = Math.toRadians(54);
		return (5 * Math.pow(edgeLength, 2 )* Math.tan(angleInRadians)) / 4;
		
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
			
		}
	}
}
