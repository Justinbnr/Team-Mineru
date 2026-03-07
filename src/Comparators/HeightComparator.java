package Comparators;

import java.util.Comparator;
import shapes.Shape;

public class HeightComparator implements Comparator<Shape> {
	// Override to catch misspelled method names
	@Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s2.getHeight(), s1.getHeight()); // Descending order
	}
}