package sorting;
import java.util.Comparator;
import shapes.Shape;



	public class QuickSort {

	    public static void quickSort(Shape[] shapes, Comparator<Shape> repo)
	    {
	        quickSort(shapes, 0, shapes.length - 1, repo);
	    }

	    private static void quickSort(Shape[] shapes, int low, int high, Comparator<Shape> repo)
	    {
	        if (low < high)
	        {
	            int pivotIndex = partition(shapes, low, high, repo);
	            quickSort(shapes, low, pivotIndex - 1, repo);
	            quickSort(shapes, pivotIndex + 1, high, repo);
	        }
	    }

	    private static int partition(Shape[] shapes, int low, int high, Comparator<Shape> repo)
	    {
	        // Median-of-3 pivot selection
	        int mid = low + (high - low) / 2;

	        // Sort low, mid, high so median ends up at mid
	        if (compare(shapes[low], shapes[mid], repo) < 0) swap(shapes, low, mid);
	        if (compare(shapes[low], shapes[high], repo) < 0) swap(shapes, low, high);
	        if (compare(shapes[mid], shapes[high], repo) < 0) swap(shapes, mid, high);

	        // Place pivot at high - 1
	        swap(shapes, mid, high - 1);
	        Shape pivot = shapes[high - 1];

	        int i = low;
	        int j = high - 1;

	        while (i <= j)
	        {
	            while (i <= j && compare(shapes[i], pivot, repo) > 0) i++;
	            while (j >= i && compare(shapes[j], pivot, repo) < 0) j--;

	            if (i < j)
	            {
	                swap(shapes, i, j);
	                i++;
	                j--;
	            }
	            else
	            {
	                i++;
	            }
	        }

	        swap(shapes, i, high - 1);
	        return i;
	    }

	    private static int compare(Shape a, Shape b, Comparator<Shape> repo)
	    {
	        if (repo != null)
	            return repo.compare(a, b);
	        return a.compareTo(b);
	    }

	    private static void swap(Shape[] shapes, int i, int j)
	    {
	        Shape temp = shapes[i];
	        shapes[i] = shapes[j];
	        shapes[j] = temp;
	    }
	
}
