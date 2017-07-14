
public class Merge {
	
	int[] join(int[] arr1, int arr1_Length, int[] arr2, int arr2_Length, int[] result ){
	
		int i=0, j = 0;
		 
		for(int k = 0 ; k< (arr1_Length + arr2_Length);k++)
		{
			//If arr1 is empty copy the elements of the array arr2 to the result array
			if ( i >= arr1_Length ){
				result[k] = arr2[j];
				j ++;
			}
			//If arr2 is empty copy the elements of the array arr1
			else if ( j >= arr2_Length){
				result[k] = arr1[i];
				i ++;
			  }
			  else{
			 
			   if ( arr1[i] < arr2[j]) {
			     result[k] = arr1[i];
			     i ++;
			    }
			    else{
			     result[k] = arr2[j];
			     j ++;
			    }
			  }
		}
		return result;
	}
}

