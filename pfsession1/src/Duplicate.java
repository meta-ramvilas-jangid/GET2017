
public class Duplicate {

	 int[] removeDuplicate(int arr[]){
	     	
		    int index[]=new int[arr.length];
			int count=0,k=-1;
			for(int i=0;i<arr.length;i++)
			{
				for(int j=i+1;j < arr.length && index[i]!=1;j++)
				{
					if(arr[i]==arr[j]){
						index[j]=1;
						count++;
					 }
				}
			}
			int unique[]=new int[arr.length-count];
			for(int i=0;i<index.length;i++){
				if(index[i]!=1){
					unique[++k]=arr[i];		
				}
			}
			return unique;
		}
 }

