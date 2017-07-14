
public class LongSequence {
      int[] longestSequence(int input[]){
		int lo=0;
		int lo1=0;
	    int hi=0;
	    int c=1;  //count the length of series
		int max=0; //maximun length of longest incresing series 
		int i=1;
		int flag=input[0];
		for(i=1;i<input.length;i++){
			if(flag<=input[i]){
			  c++;
			  flag=input[i];
		    }  else if(flag>input[i]){
			    if(max<c){
				  max=c;
				  hi=i-1;
				  lo=lo1;
			     }
			    c=1;
			    lo1=i;
			    flag=input[i];
		       }
		}
		 if(max<c){
			  max=c;
			  hi=i-1;
			  lo=lo1;
		     }
		int[] result=new int[max];
		System.out.println(" max lo ho"+max+" "+lo+" "+hi);
		for(int p=lo,z=0;p<=hi;p++,z++){
			result[z]=input[p];
		}
		return result;
	}

}
