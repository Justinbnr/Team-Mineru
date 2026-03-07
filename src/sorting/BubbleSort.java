package sorting;
import java.util.Comparator;

import shapes.Shape;


public class BubbleSort {

	public static void bubbleSort (Shape[] shapes, Comparator<Shape> repo) {
		// increments through the array
		for (int i = 0; i < shapes.length; i++) {
			// Increments through the following indexes
			for (int j = 1; j < shapes.length - i; j++) {
				// Swaps the indexes if the left index is > the right  using comapre()
				if (repo.compare(shapes[j - 1], shapes[j]) < 0) {
					// Swap the shapes
					swap(shapes, j, j -1);
				}
				
			}
		}
	}	
	
	// Swap function
	private static void swap(Shape[] shapes, int Index1, int Index2) {
		// Saves temp as Index 1, then swaps Index 2 to 1 and re-assign temp to Index 2
		Shape temp = shapes[Index1];
		shapes[Index1] = shapes[Index2];
		shapes[Index2] = temp;
	}

}
