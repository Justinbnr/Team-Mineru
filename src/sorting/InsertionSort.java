package sorting;

import java.util.Comparator;

import shapes.Shape;

public class InsertionSort {

	public static void insertionSort (Shape[] shapes, Comparator<Shape> repo ){

		for (int i = 1; i < shapes.length; i++) {
			Shape key  = shapes[i];
			int j = i - 1;
			
			while (j >= 0 && repo.compare(shapes[j], key) < 0) {
				shapes[j = 1 ] = shapes[j];
				j --;
			}
				shapes[ j + 1 ] = key;
			}
		}
	}

