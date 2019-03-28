import java.util.Scanner;

public class Main {
 
    
	static long startTime;
	public static void main(String args[]) throws Exception
	{
    	System.out.println("Enter numbers to sort : \nEx: 10, 100, 1000, 10000,..., n");
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] array = new int[n];
    	for(int i=0; i<n; i++) {
			array[i] = (int) (Math.random() * ((1000 - 1) + 1)) + 1;
		}
		//printArray(array, "Given Array: ", false);
		//To calculate time taken to find the solution

		/*--------------------Insertion Sort--------------------*/
		startTime = System.nanoTime();
		int[] A = InsertionSort.sort(array);
		printArray(A, "\n\nInsertion Sort ", true);
		
		/*--------------------Merge Sort--------------------*/
		startTime = System.nanoTime();
		MergeSort.mergeSort(array);
		printArray(A, "Merge Sort : ", true);
		
		/*--------------------Quick Sort--------------------*/
		startTime = System.nanoTime();
		QuickSort.quickSort(array, 0, array.length-1);
		printArray(array, "Quick Sort : ", true);
		
		/*--------------------Quick Sort Median of 3 with Insertion sort--------------------*/
		QuickSortMedian3.quicksort(array);
		QuickSortMedian3.print(array, "Quick Sort Median of 3 : ", true);
		
    }

    public static void printArray(int[] numbers, String message, boolean showDuration) {

    	System.out.println("\n"+message);
	//	for(int i=0; i<numbers.length; i++) {
	//		System.out.print(numbers[i]+" ");
	//	}
		if(showDuration) {
			long duration = System.nanoTime() - startTime;
			System.out.println("\nTime taken to find the solution");
			System.out.println(duration/1000000000.0 + " s");
		}
	}
}
