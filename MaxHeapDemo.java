//#################################################################################################
// Demonstration of Max Heap
// --------------------------------------------------------------------
// Mark Barros
// CS2400 - Data Structures and Advanced Programming
// California State Polytechnic University: Spring 2021
//#################################################################################################

// Necessary Imports. -----------------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;

// Demonstration of the Max Heap. -----------------------------------------------------------------
public class MaxHeapDemo {
	
	public static void main(String [] args) throws FileNotFoundException {
			
		// Data Fields ----------------------------------------------------------------------------
		
		final int CAPACITY = 101;
		int index = 1;
		Integer [] tempIntegerArray;	
		File inputFile = new File("data.txt");
		Scanner readFile = new Scanner(inputFile);
		PrintWriter heapOutputFile = new PrintWriter("Max Heap Output.txt");
		String divider =
				"================================================================================";
		
		// Display header -------------------------------------------------------------------------
				
		System.out.println(divider);
		System.out.println("Max-Heap Using Array Representation");
		System.out.println("By Mark Barros");
		System.out.println("CS2400 - Data Structures and Advanced Programming - Spring 2020");
		System.out.println("California State Polytechnic Institute");
		System.out.println(divider);
		heapOutputFile.write(divider + "\n");

		// Populating temporary array with integers from data.txt ---------------------------------
	
		Integer [] temp = new Integer[CAPACITY];
		tempIntegerArray = temp;

		while(readFile.hasNext()) {
			tempIntegerArray[index] = readFile.nextInt();
			index++;
		}

		readFile.close();
		System.out.println("Integers acquired from: '" + inputFile.getPath() + "'");	
		
		// Sequential insertions heap operations --------------------------------------------------
	
		MaxHeap SequentialMaxHeap = new MaxHeap(CAPACITY);
		index = 1;

		while(index < CAPACITY) {
			SequentialMaxHeap.add(tempIntegerArray[index]);
			index++;
		}

		System.out.println(divider);

		System.out.print("Heap built using sequential insertions: ");
		heapOutputFile.write("Heap built using sequential insertions: ");

		for(int i = 1; i <= 10 ; i++) {
			System.out.print(SequentialMaxHeap.getValueAt(i));
			heapOutputFile.write(String.valueOf(SequentialMaxHeap.getValueAt(i)));

			if(i<=9) {
				System.out.print(", ");
				heapOutputFile.write(", ");
			}

		} // end for

		System.out.println("\nNumber of swaps in the heap creation: "
				+ SequentialMaxHeap.getSequentialSwapCount());
		heapOutputFile.write("\nNumber of swaps in the heap creation: "
				+ SequentialMaxHeap.getSequentialSwapCount()+ "\n");

		for(int i = 1; i <= 10 ; i++) {
			SequentialMaxHeap.removeMax();
		}

		System.out.print("Heap after 10 removals: ");
		heapOutputFile.write("Heap after 10 removals: ");

		for(int i = 1; i <= 10 ; i++) {
			System.out.print(SequentialMaxHeap.getValueAt(i));
			heapOutputFile.write(String.valueOf(SequentialMaxHeap.getValueAt(i)));

			if(i<=9) {
				System.out.print(", ");
				heapOutputFile.write(", ");
			}

		} // end for
		
		// Optimal method heap operations ---------------------------------------------------------
		
		System.out.print("\n\nHeap built using optimal method: ");
		heapOutputFile.write("\n\nHeap built using optimal method: ");
		MaxHeap OptimalMaxHeap = new MaxHeap(tempIntegerArray);

		for(int i = 1; i <= 10; i++) {
			System.out.print(OptimalMaxHeap.getValueAt(i));
			heapOutputFile.write(String.valueOf(OptimalMaxHeap.getValueAt(i)));

			if(i<=9) {
				System.out.print(", ");
				heapOutputFile.write(", ");
			}

		} // end for

		System.out.println("\nNumber of swaps in the heap creation: "
				+ OptimalMaxHeap.getOptimalSwapCount());
		heapOutputFile.write("\nNumber of swaps in the heap creation: "
				+ OptimalMaxHeap.getOptimalSwapCount() + "\n");

		for(int i = 1; i <= 10 ; i++) {
			OptimalMaxHeap.removeMax();
		}

		System.out.print("Heap after 10 removals: ");
		heapOutputFile.write("Heap after 10 removals: ");

		for(int i = 1; i <= 10; i++) {
			System.out.print(OptimalMaxHeap.getValueAt(i));
			heapOutputFile.write(String.valueOf(OptimalMaxHeap.getValueAt(i)));

			if(i<=9) {
				System.out.print(", ");
				heapOutputFile.write(", ");
			}
			
		} // end for

		System.out.println("\n" + divider);
		System.out.println("These results are being written to the following " +
						   "file: 'Max Heap Output.txt'");
		System.out.println(divider);
		heapOutputFile.write("\n" + divider);
		
		heapOutputFile.close();

	} // end main

} // end MaxHeapDemo ##############################################################################
