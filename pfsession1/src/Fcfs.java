public class Fcfs {
	/**
	 * @param arrival_time
	 * @param Job_size
	 * @return output that contain s.no,arrival_time,waiting_time,start_time,finish_time 
	 */
	int[][] fcfs(int[] arrival_time, int[] Job_size){
		int wait[]=new int[arrival_time.length];                       
		int finish[]=new int[arrival_time.length];
		int start[]=new int[arrival_time.length];

		wait[0]=0;                                          //first process waiting time is 0
	    start[0]=arrival_time[0];
	    finish[0]= Job_size[0];
	    for(int i=1;i<arrival_time.length;i++)
		{
			wait[i]=finish[i-1]-arrival_time[i]+1;      //waiting time of ith is finish time of 
			                                            //(i-1)th -arrival time of ith process 
			if(wait[i]<0){                               //if waiting time is negative then wait[i]=0
				wait[i]=0;
			}
			if(wait[i]==0){
			
				start[i]=arrival_time[i];              //ith start time is (i-1)th finish time+1
			}else{
				start[i]=finish[i-1]+1;
			}
		    finish[i]=start[i]+Job_size[i]-1;	
	    }
	    int[][] output =new int[arrival_time.length][5];
	    for(int i=0;i<arrival_time.length;i++)
	    {
	    	output[i][0]=i+1;
	    	output[i][1]=arrival_time[i];
	    	output[i][2]=wait[i];
	    	output[i][3]=start[i];
	    	output[i][4]=finish[i];
	    }
	    return output;
	}
}
