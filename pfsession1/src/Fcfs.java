public class Fcfs {
	int[][] fcfs(int[] arr,int[] size)
	{
		int n=arr.length;
		int wait[]=new int[n];
		int finish[]=new int[n];
		int start[]=new int[n];

		wait[0]=0;
	    start[0]=arr[0];
	    finish[0]= size[0];
	    for(int i=1;i<n;i++)
		{
			wait[i]=finish[i-1]-arr[i]+1;
			if(wait[i]<0)
			{
				wait[i]=0;
			}
			if(wait[i]==0)
			{
				start[i]=arr[i];
			}else{
				start[i]=finish[i-1]+1;
			}
		    finish[i]=start[i]+size[i]-1;	
	    }
	    int[][] output =new int[n][5];
	    for(int i=0;i<n;i++)
	    {
	    	output[i][0]=i+1;
	    	output[i][1]=arr[i];
	    	output[i][2]=wait[i];
	    	output[i][3]=start[i];
	    	output[i][4]=finish[i];
	    }
	    
	    for(int i=0;i<n;i++)
	    {
	    	for(int j=0;j<5;j++)
	    	{
	    		System.out.print("  "+output[i][j]+"  ");
	    	}
	    	System.out.println();	    	
	    }
	    return output;
	}
}
