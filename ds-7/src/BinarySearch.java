import java.util.Arrays;

public class BinarySearch {

	static boolean flag=false;
	int  binarySearch(int arr[], int low, int high, int find) {
		/*
		 * at first check for array is sorted or not,if not return exception
		 */
		if(!flag){
			int newArray[]=Arrays.copyOf(arr, arr.length);
			Arrays.sort(newArray);
			if(Arrays.equals(arr, newArray)){
				System.out.println("in flag exception");
				flag=true;
			}else{
				System.out.println("in exception");
				 throw new IllegalArgumentException() ;
			}
		}
		
		if (high >= low) {
			int mid = (high+low) / 2;

			// If the element is present at the middle itself
			if (arr[mid] == find){
				return checkForLeft(arr,mid);
				
			}
			// If element is smaller than mid, then it can only
			// be present in left subarray
			if (arr[mid] > find)
				return binarySearch(arr, low, mid - 1, find);

			// Else the element can only be present in right
			// subarray
			return binarySearch(arr, mid + 1, high, find);
		}

		// We reach here when element is not present in array
		return -1;
	}

	int checkForLeft(int[] arr, int index){
		int i;
		for(i=index; i>0; ){
			if(arr[i]==arr[i-1]){
				i--;
			}else{
				break;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]={12,13,18,20};
      BinarySearch b=new BinarySearch();
      System.out.print(b.binarySearch(arr, 0, (arr.length-1), 20));
		
	}

}
