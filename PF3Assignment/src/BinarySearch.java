public class BinarySearch{
	/**
	 * @param arr take sorted integer array
	 * @param first first index of arr
	 * @param last  last index of arr
	 * @param search_key element that is present or not in arr 
	 * @return if search key found then return index of search key,if not found return -1 	
	 */
	int binarySearch(int[] arr, int first, int last, int search_key){
		int mid;
		if(arr.length==0){
			throw new IllegalArgumentException();
		}
		if(first==last){ 
			if(arr[first]==search_key){
				return first;
		   }else{
			   return -1;
		    }
		}else{
			mid=(first+last)/2;
			if(arr[mid]==search_key){
				return mid;
		    }
		    if(search_key<arr[mid]){
		    	return binarySearch(arr, first, mid-1, search_key); 
		    }else{
		    	if(search_key>arr[mid]){
		    		return binarySearch(arr, mid+1, last, search_key);
		    	}else{
		    		return -1;
		    	}
		    }
		 }   
	}
}
