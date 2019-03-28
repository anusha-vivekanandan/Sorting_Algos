public class InsertionSort {	
	public static int[] sort(int[] A) {
		for(int i=1; i< A.length; i++) {
			int key = A[i];
			int j = i-1;
			while(j>=0 && A[j] > key) {
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = key;
		}
		return A;
	}
	
	public static void print(int[] numbers, String message) {
		System.out.println("\n"+message);
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
	}
}
