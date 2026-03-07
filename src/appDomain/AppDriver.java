package appDomain;
import java.util.Scanner;

import Comparators.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import sorting.*;



/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * W2026 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver {
    /**
     * The main method is the entry point of the application.
     * parse command-line arguments and sorting process
     *
     *
     * @param args The input to control the execution of the application.
     */
    public static void main(String[] args) {
        // variables for file scanning and reading
        String fileName = null;
        char compareType = '\0';
        char sortType = '\0';

        // parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toLowerCase();
            if (arg.startsWith("-f")) {
                // filename either attached to -f or next argument
                if (arg.length() > 2) {
                    fileName = args[i].substring(2);
                } else {
                    fileName = args[++i];
                }
            } else if (arg.startsWith("-t")) {
                // comparison type
                String tStr;
                if (arg.length() > 2) {
                    tStr = arg.substring(2);
                } else {
                    tStr = args[++i];
                }
                compareType = Character.toLowerCase(tStr.charAt(0));
            } else if (arg.startsWith("-s")) {
                // sort type
                String sStr;
                if (arg.length() > 2) {
                    sStr = arg.substring(2);
                } else {
                    sStr = args[++i];
                }
                sortType = Character.toLowerCase(sStr.charAt(0));
            }
        }

        // check if all required arguments to run the program are given
        if (fileName == null || compareType == '\0' || sortType == '\0') {
            System.out.println("Usage: java -jar Sort.jar -f<filename> -t<h|v|a> -s<b|i|s|m|q|z>");
            System.exit(1);
        }

        // check if the comparison type is valid
        if (compareType != 'h' && compareType != 'v' && compareType != 'a') {
            System.out.println("Invalid compare type. Please select one of the following: h, v, or a.");
            System.exit(1);
        }

        // check if the sort type is valid
        if ("bisqmz".indexOf(sortType) == -1) {
            System.out.println("Invalid sort type. Please select on of the following: b, i, s, m, q, or z.");
            System.exit(1);
        }

        // read the shape objects from specified file
        Shape[] shapes = readShapesFromFile(fileName);
        if (shapes == null) {
            System.exit(1);
        }

        // select the appropriate comparator method based on the compare type (h, v, or a)
        Comparator<Shape> comp = null;
        String propertyName = "";
        if (compareType == 'h') {
            comp = new HeightComparator();
            propertyName = "Height";
        } else if (compareType == 'v') {
            comp = new VolumeComparator();
            propertyName = "Volume";
        } else if (compareType == 'a') {
            comp = new BaseAreaComparator();
            propertyName = "Area";
        }

        // select the appropriate sorting method based on the sort type (b, i, s, m, q, or z)
        // declare sortName variable 
        String sortName = "";
        
        // start benchmarking timer
        long startTime = System.nanoTime();
        
        // perform the sort based on the sorting algorithm 
        switch (sortType) {
            case 'b':
                BubbleSort.bubbleSort(shapes, comp);
                sortName = "Bubble";
                break;
            case 'i':
                InsertionSort.insertionSort(shapes, comp);
                sortName = "Insertion";
                break;
            case 's':
                SelectionSort.selectionSort(shapes, comp);
                sortName = "Selection";
                break;
            case 'm':
                MergeSort.mergeSort(shapes, comp);
                sortName = "Merge";
                break;
            case 'q':
                QuickSort.quickSort(shapes, comp);
                sortName = "Quick";
                break;
            // add switch case for the 6th sorting method when implemented
            case 'z':
                break;
        }

        // end benchmarking timer 
        long endTime = System.nanoTime();
        // calculate duration in milliseconds
        long durationMs = (endTime - startTime) / 1_000_000;

        // print the sorted elements at specific positions
        printSortedElements(shapes, propertyName, compareType);

        // output the sorting time
        System.out.println(sortName + " Sort run time was: " + durationMs + " milliseconds");
    }

    private static Shape[] readShapesFromFile(String fileName) {
        Shape[] shapes = null;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            // read the number of shapes
            int numShapes = scanner.nextInt();
            shapes = new Shape[numShapes];
            for (int i = 0; i < numShapes; i++) {
                // read shape type, height and parameter (radius or edge length)
                String type = scanner.next();
                double height = scanner.nextDouble();
                double param = scanner.nextDouble();
                // call the appropriate shape subclass based on type
                switch (type) {
                    case "Cone":
                        shapes[i] = new Cone(height, param);
                        break;
                    case "Cylinder":
                        shapes[i] = new Cylinder(height, param);
                        break;
                    case "Pyramid":
                        shapes[i] = new Pyramid(height, param);
                        break;
                    case "OctagonalPrism":
                        shapes[i] = new OctagonalPrism(height, param);
                        break;
                    case "PentagonalPrism":
                        shapes[i] = new PentagonalPrism(height, param);
                        break;
                    case "SquarePrism":
                        shapes[i] = new SquarePrism(height, param);
                        break;
                    case "TriangularPrism":
                        shapes[i] = new TriangularPrism(height, param);
                        break;
                    default:
                        System.out.println("Unknown shape type: " + type);
                        return null;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return null;
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return shapes;
    }

    private static void printSortedElements(Shape[] shapes, String propertyName, char compareType) {
        int n = shapes.length;
        // print the first element
        System.out.println("First element is: " + shapes[0].getClass().getName() + " " + propertyName + ": " + getPropertyValue(shapes[0], compareType));

        // print every 1000th element
        for (int k = 1000; k <= n; k += 1000) {
                System.out.println(k + "-th element: " + shapes[k - 1].getClass().getName() + " " + propertyName + ": " + getPropertyValue(shapes[k - 1], compareType));
        }

        // print the last element
        System.out.println("Last element is: " + shapes[n - 1].getClass().getName() + " " + propertyName + ": " + getPropertyValue(shapes[n - 1], compareType));
    }

    // get the value of the specified properties for a shape
    // the shape object, the compare type (h, v or a) and return the compare value
    private static double getPropertyValue(Shape shape, char compareType) {
        if (compareType == 'h') {
            return shape.getHeight();
        } else if (compareType == 'v') {
            return shape.getVolume();
        } else if (compareType == 'a') {
            return shape.getBaseArea();
        }
        return 0;
    }
}


