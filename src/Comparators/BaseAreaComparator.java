package Comparators;

import java.util.Comparator;
import shapes.Shape;

public class BaseAreaComparator implements Comparator<Shape> {
	// Override to catch misspelled method names
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s2.getBaseArea(), s1.getBaseArea()); // Descending order
    }
}