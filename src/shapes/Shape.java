package shapes;

public abstract class Shape implements Comparable<Shape> {
	private double height;
	public Shape(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
		
	}
	public abstract double getBaseArea();
	public abstract double getVolume();
}
