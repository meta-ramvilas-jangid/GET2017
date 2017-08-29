
public class MyHeapSort {

	
	public  void heapify(int []arr, int i, int n){
		int largest = i;  
        int l = 2*i + 1;  
        int r = 2*i + 2;  
 
        if (l < n && arr[l] > arr[largest]){
            largest = l;
	    }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
	}
	public  void heapSort(int arr[],int n){
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,i,n);
		}
		for(int i=n-1;i>=0;i--){
			int tmp=arr[i];
            arr[i]=arr[0];
            arr[0]=tmp;
			heapify(arr,0,i);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={7,8,3,5};
		int n=arr.length;
		MyHeapSort h=new MyHeapSort();
		h.heapSort(arr,n);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}

}
