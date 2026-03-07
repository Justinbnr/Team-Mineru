package sorting;
import java.util.Comparator;

import shapes.Shape;

public class HeapSort {
	// compare-based sorting that uses binary heaps to sort elements into an array in place
	// structures the array into a binary tree structure called a heap and continuously creates max-heaps to find the largest element  
	public static void heapSort(Shape[] shapes, Comparator<Shape> repo) {
		// if the array is empty or has only one element assume it is already sorted
		if (shapes == null || shapes.length <= 1)
		{
			return;
		}
		
		// store the length of the array into a variable
		int n = shapes.length;
		
		// build a max-heap from the entire array
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			heapify(shapes, n, i, repo);
		}
		
		// extract the largest element repeatedly
		for (int i = n - 1; i > 0; i--)
		{
			// swap the largest element with the last element of the heap
			swap(shapes, 0, i);
			heapify(shapes, i, 0, repo);
		}	
	}
	
	// helper method that maintains the max-heap
	private static void heapify(Shape[] shapes, int n, int i, Comparator<Shape> repo) {
		// assume current node is the largest among itself and its children
		int largest = i;
		// calculate index of left child
		int left = 2 * i + 1;
		// calculate index of right child
		int right = 2 * i + 2;
		
		// check if left child exists and is larger than current largest
		if (left < n && repo.compare(shapes[left], shapes[largest]) > 0)
		{
			// if left child is larger, update largest index
			largest = left;
		}
		
		// check if right child exists and is larger than the current largest
		if (right < n && repo.compare(shapes[right], shapes[largest]) > 0) 
		{
			// if right is larger, update largest index
			largest = right;
		}
		
		// if the largest element is not the current node 
		if (largest != i) 
		{
			// swap parent with the larger child
			swap(shapes, i, largest);
			// re-heapify the affected subtree 
			heapify(shapes, n, largest, repo);
		}
	}
	// helper method to sway two elements in the array
	private static void swap(Shape[] shapes, int i, int j) {
		// store one element temporarily
		Shape temp = shapes[i];
		// move second element to first position
		shapes[i] = shapes[j];
		// put temporary into second position
		shapes[j] = temp;
	}

}
