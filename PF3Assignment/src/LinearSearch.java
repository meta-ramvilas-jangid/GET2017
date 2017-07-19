public class LinearSearch{
	/**
	 * 
	 * @param array is integer array
	 * @param found_index contain index value during iteration,initialy contain starting index
	 * @param search_key key that want to search
	 * @return index of key value if found otherwise return -1
	 */
	int linearSearch(int[] array, int found_index, int search_key){
		if((array.length-1) < found_index){
			return -1;
		}
		if(array[found_index]==search_key){
			return found_index;
		}
		return linearSearch(array, found_index + 1, search_key);
	}

}
