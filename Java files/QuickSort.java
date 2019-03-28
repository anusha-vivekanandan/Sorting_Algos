public class QuickSort {
	public static void quickSort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		//For right most index as pivot
		int index = partition(array, left, right);
		// For randomized sort
		//int index = partition_RandomPivot(array, left, right);
		quickSort(array, left, index-1);
		quickSort(array, index+1, right);
	}
	/* This function takes last element as pivot, places the pivot element at its correct position in sorted array, 
	 * and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot 
	 * @param array elements
	 * @param left - lower index value
	 * @param right - higher index value
	 */
	public static int partition(int[] array, int left, int right) {
			int index = left -1;
			int pivot = right;
			for(int j=left; j<right; j++) {
				if(array[j] <= array[pivot]) {
					index++;
					swap(array, index, j);
				}
			}
			swap(array, index + 1, right); 
		return index+1;
	}
	
	/*
	 * Swap function
	 * @param array elements
	 * @param left - first index
	 * @param right - second index
	 */
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	/* Generates Random Pivot, swaps pivot with end element and calls the partition function 
	 * @param array elements
	 * @param left - lower index value
	 * @param right - higher index value
	 */
	static int partition_RandomPivot(int array[], int left, int right) 
	{ 
	    // Generate a random number in between 
	    // low .. high 
	    int random = (int) (left + Math.random() % (right - left)); 
	  
	    // Swap A[random] with A[high] 
	    swap(array, random, right); 
	  
	    return partition(array, left, right); 
	} 
}
