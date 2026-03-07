package shapes;

public abstract class Shape implements Comparable<Shape> {
	private double height;
	public Shape(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
		
	}
	// these are here because the classes that have the getbase and getvolume should do the math for us //
	public abstract double getBaseArea();
	public abstract double getVolume();
	
	// This is added to make the other shape classes un-abstracted haha
	@Override
    public int compareTo(Shape other) {
        return Double.compare(other.getHeight(), this.getHeight());
    }

}
