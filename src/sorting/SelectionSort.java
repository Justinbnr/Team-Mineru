package sorting;

import java.util.Comparator;

import shapes.Shape;

public class SelectionSort {

    public static void selectionSort(Shape[] shapes, Comparator<Shape> repo) 
    {
    	// store the length of the array into a variable
        int n = shapes.length;
        // outer loop iterate through the array from the start to the second last index (last index element is automatically sorted)
        for (int i = 0; i < n - 1; i++) 
        {
        	// assume the current index i is the position of the maximum element in the unsorted part of the array
        	// this will be used in swapping it to it's correct position
            int maxIdx = i;
            // inner loop iterates through the unsorted part of the array to find the actual maximum
            for (int j = i + 1; j < n; j++) 
            {
            	// if the element while passing through the array is larger than the element at our current index 
                if (repo.compare(shapes[j], shapes[maxIdx]) > 0) 
                {
                	//set new maximum element to j if a larger element is found 
                    maxIdx = j;
                }
            }
            // after finding max, check if it's not already in position i
            if (maxIdx != i) 
            {
            	// swap the element at i with the max element to place the largest at the front of the sorted array
                swap(shapes, i, maxIdx);
            }
        }
    }
    // helper method to swap an element into it's correct position in the array
    private static void swap(Shape[] shapes, int idx1, int idx2) 
    {
    	// store the element at index 1 in a temporary variable
        Shape temp = shapes[idx1];
        // assign the element at index 2 to index 1
        shapes[idx1] = shapes[idx2];
        // assign the temporary (was originally index 1) to index 2
        shapes[idx2] = temp;
    }

}