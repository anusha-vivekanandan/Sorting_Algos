public class QuickSortMedian3 {
	/**
	 * Quicksort algorithm.
	 * @param a an array of Comparable items.
	 */
	public static void quicksort( int [ ] a ) {
		quicksort( a, 0, a.length - 1 );
	}

	private static final long startTime = System.nanoTime();
	/**
	 * Internal quicksort method that makes recursive calls.
	 * Uses median-of-three partitioning and a cutoff of 10.
	 * @param array an array of Comparable items.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private static void quicksort( int [ ] array, int left, int right ) {
		if( left + 10 > right )
			insertionSort( array, left, right );
		else {
			// Sort low, middle, high
			int middle = ( left + right ) / 2;
			if( array[ middle ] < array[ left ] )
				swap( array, left, middle );
			if( array[ right ] < array[ left ])
				swap( array, left, right );
			if( array[ right ] < array[ middle ])
				swap( array, middle, right );

			// Place pivot at position high - 1
			swap( array, middle, right - 1 );
			int pivot = array[ right - 1 ];

			// Begin partitioning
			int i, j;
			for( i = left, j = right - 1; ; ) {
				while( array[ ++i ] < pivot )
					;
				while( pivot < array[ --j ] )
					;
				if( i >= j )
					break;
				swap( array, i, j );
			}
 
			// Restore pivot
			swap( array, i, right - 1 );

			quicksort( array, left, i - 1 );    // Sort small elements
			quicksort( array, i + 1, right );   // Sort large elements
		}
	}

	/**
	 * Method to swap to elements in an array.
	 * @param array an array of objects.
	 * @param index1 the index of the first object.
	 * @param index2 the index of the second object.
	 */
	public static final void swap( int [ ] array, int index1, int index2 ) {
		int tmp = array[ index1 ];
		array[ index1 ] = array[ index2 ];
		array[ index2 ] = tmp;
	}


	/**
	 * Internal insertion sort routine for subarrays
	 * that is used by quicksort.
	 * @param array an array of Comparable items.
	 * @param left the left-most index of the subarray.
	 * @param n the number of items to sort.
	 */
	private static void insertionSort( int [ ] array, int left, int right ) {
		for( int p = left + 1; p <= right; p++ ) {
			int tmp = array[ p ];
			int j;

			for( j = p; j > left && tmp < array[ j - 1 ] ; j-- )
				array[ j ] = array[ j - 1 ];
			array[ j ] = tmp;
		}
	}
	
	public static void print(int[] numbers, String message, boolean showDuration) {
	//	System.out.println("\n"+message);
	//	for(int i=0; i<numbers.length; i++) {
	//		System.out.print(numbers[i]+" ");
	//	}
		if(showDuration) {
			final long duration = System.nanoTime() - startTime;
			System.out.println("\nTime taken to find the solution for median of 3");
			System.out.println(duration/1000000000.0 + " s");
		}
	}
}
