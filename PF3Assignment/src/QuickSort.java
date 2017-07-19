public class QuickSort{
	/**
	 * 
	 * @param array is integer array
	 * @param first is first index of array
	 * @param last is last idex of array
	 * @return sorted array
	 */
	int[] quicksort(int array[],int first,int last){
		if(array.length==0){
			throw new IllegalArgumentException();
		}
		int pivot=0;
		int i;         //variable that start with first index and iterate the index
		int j;         ////variable that start with last index and iterate the index
		int temp;
	    if(first<last){
	    	pivot=first;
	        i=first;
	        j=last;
	        while(i<j){
	        	while(array[i]<=array[pivot] && i<last){
	            	 i++;
	             }
	             while(array[j]>array[pivot]){
	            	 j--;
	             }
	             if(i<j)
				 {
	                 temp=array[i];
	                  array[i]=array[j];
	                  array[j]=temp;
	             }
	         }
	         temp=array[pivot];
	         array[pivot]=array[j];
	         array[j]=temp;
	         quicksort(array,first,j-1);
	         quicksort(array,j+1,last);
	    }     
    return array;
	}
}
