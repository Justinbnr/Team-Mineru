package sorting;
import java.util.Comparator;
import shapes.Shape;

public class MergeSort {
	public static void mergeSort (Shape[] shapes, Comparator<Shape> repo ) {
		int shapeLength = shapes.length;
		
		if (shapeLength < 2 ) {
			return;
		}
		int midIndex = shapeLength  / 2;
		Shape[] leftHalf = new Shape [midIndex];
		Shape[] rightHalf = new Shape [shapeLength - midIndex];
		
		for (int i = 0; i < midIndex; i++ ) {
			leftHalf[i] = shapes[i];
		}
		for (int i = midIndex; i < shapeLength; i++ ) {
			rightHalf[i - midIndex] = shapes[i];
		}
	
		mergeSort (leftHalf, repo);
		mergeSort (rightHalf, repo);
		
		merge(shapes, leftHalf, rightHalf, repo );

	}
	
	private static void merge (Shape[]shapes, Shape [] leftHalf, Shape [] rightHalf, Comparator<Shape> repo) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < leftSize && j < rightSize ) {
			if (repo.compare(leftHalf[i], rightHalf [j]) >= 0) {
				shapes[k] = leftHalf[i];
				i++;
			}
				else {
					shapes[k] = rightHalf[j];
					j++;
				}
				k++;
			}
		while (i < leftSize) { 
			shapes[k] = leftHalf[i];
		i++;
		k++;
			
		}
		
		while (j < rightSize) 
		{ shapes[k] = rightHalf[j];
		j++;
		k++;
		}
			
	}
	
}