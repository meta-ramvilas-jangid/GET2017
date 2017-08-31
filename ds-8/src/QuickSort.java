public class QuickSort {
	
	public static int[] quickSort(int arr[]){
		System.out.println("Quick Sort");
		return quickSort(arr,0,arr.length-1);
	}
	
	private static int[] quickSort(int arr[], int startIndex, int endIndex) {
		if(arr.length==0){
			throw new IllegalArgumentException("input array should not be empty");         		
		}else if(startIndex < endIndex){														
			int pi = partition(arr, startIndex, endIndex);										
			quickSort(arr, startIndex, pi-1);													
			quickSort(arr, pi+1, endIndex);														
		}
		return arr;																				
	}
	
	
	/**
	 *  This function takes last element as pivot, places
	 *  the pivot element at its correct position in sorted
	 *  array, and places all smaller (smaller than pivot)
	 *  to left of pivot and all greater elements to right
	 *  of pivot 
	 */
	private static int partition(int[] arr, int startIndex, int endIndex){
		int pivot = arr[endIndex];															
		int i = startIndex-1,j;
		for(j = startIndex; j < endIndex; j++ ){
			if(arr[j] <= pivot){
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[endIndex];
		arr[endIndex] = temp;
		return i+1;
	}
}
