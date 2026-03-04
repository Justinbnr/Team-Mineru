import java.util.Scanner;
import java.io.File;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;


package appDomain;


/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * W2026 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)
		
		// This is the Scanner to read the file, it will tell us how big the array is and fill it with all the shapes // 
	public Shape[] loadFile(String fileName) throws Exception{
		Scanner fileScanner = new Scanner(new File(fileName));
		
		int size = fileScanner.nextInt();
		Shape[] allShapes = new Shape[size];
		
		for (int i  = 0; i < size; i++) {
			String name = fileScanner.next();
			double h = fileScanner.nextDouble();
			double v = fileScanner.nextDouble();
			
			if (name.equalsIgnoreCase("Cone")) {
				allShapes[i] = new Cone(h, v);
			} else if (name.equalsIgnoreCase("Cylinder")) {
				allShapes[i] = new Cylinder(h, v);
			} else if (name.equalsIgnoreCase("OctagonalPrism")) {
				allShapes[i] = new OctagonalPrism(h, v);
			} else if (name.equalsIgnoreCase("PentagonaPrism")) {
				allShapes [i] = new PentagonalPrism(h, v);
			} else if (name.equalsIgnoreCase("Pyramid")) {
				allShapes [i] = new Pyramid(h, v);
			} else if (name.equalsIgnoreCase("SquarePrism")){
				allShapes [i] = new SquarePrism(h, v);
			} else if (name.equalsIgnoreCase("TriangularPrism")) {
				allShapes [i] = new TriangularPrism(h, v);
			}}
		fileScanner.close();
		return allShapes;
		}
	}


