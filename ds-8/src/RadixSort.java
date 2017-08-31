import java.io.*;
import java.util.*;
 
class RadixSort {
    /**
     *  A function to do counting sort of arr[] according to the digit represented by exp.
     */
    static void cSort(int arr[], int n, int exp) {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        /* Store count of occurrences in count[]*/
        for (i = 0; i < n; i++) {
        	count[ (arr[i]/exp)%10 ]++;
        }
            
 
        /**
         *  Change count[i] so that count[i] now contains
         * actual position of this digit in output[]  
         */
        for (i = 1; i < 10; i++) {
        	count[i] = count[i] + count[i - 1];
        }
            
 
        /**
         * arrange value in
         */
        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        /**
         *  Copy the output array to arr[], so that arr[] now
         *  contains sorted numbers according to curent digit
         */
        for (i = 0; i < n; i++){
        	arr[i] = output[i];
        }
            
    }
 
    /**
     *  The main function to that sorts arr[] of size n using
     *  Radix Sort
     */
  
    static int[] radixSort(int arr[]) {
    	System.out.println("Radix Sort");
        int m = SortUtil.getMax(arr, arr.length);
 
        /**
         *  Do counting sort for every digit. Note that instead
         *  of passing digit number, exp is passed. exp is 10^i
         *  where i is current digit number
         */
       
        for (int exp = 1; m/exp > 0; exp *= 10){
        	cSort(arr, arr.length, exp);
        }
            return arr;
    }
 

}