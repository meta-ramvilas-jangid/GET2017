public class Pattern1 {
    String space(int row, int n){
    	String pattern="";
    	if(row<n){
    		for(int i=0; i<(n-row); i++){
    			pattern=pattern+" ";
    		}
    	}else{
    		for(int i=0; i<(row-n); i++){
    			pattern=pattern+" ";
    		}
    	}
    	return pattern;	
    }
    String number(int row, int n){   	
    	int total_col=2*n-1;
    	String pattern="";
    	int count=1;
		boolean flag=true;
    	if(row<=n){
    		for(int i=0; i<2*(row)-1; i++){
    			pattern=pattern+count;
    			if(count>=row && flag){
    				flag=false;
    			}
    			if(flag){
    				count++;
    			}else{
    				count--;
    			}
    		}
    	}else{
    		for(int i=0; i<2*(total_col-row+1)-1; i++){
    			pattern=pattern+count;
    			if(count>=(total_col-row+1) && flag){
    				flag=false;
    			}
    			if(flag){
    				count++;
    			}else{
    				count--;
    			}
    		}
    	}
    	return pattern;	
    }
    String[] print(int n){
    	int total_row=2*n-1;
    	String pattern[]=new String[total_row];
    	for(int i=1; i<=total_row; i++){
    		pattern[i-1]=space(i,n);
    		pattern[i-1]+=number(i,n);
    	}
    	return pattern;
    }
}
