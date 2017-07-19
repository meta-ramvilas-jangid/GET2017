public class Pattern2 {
	String space(int row, int n){
		String pattern="";	
		for(int j=0; j<(row-1); j++)
			{
			pattern=pattern+" ";
			}
		return pattern;
	}
	String number(int row, int n){
		String pattern="";
		int count=1;
		for(int j=0; j<=(n-row);j++){
			pattern=pattern+count;
			count++;
		}
		return pattern;
	}
	String[] print(int n){
    	String pattern[]=new String[n];
    	for(int i=1; i<=n; i++){
    		pattern[i-1]=space(i,n);
    		pattern[i-1]+=number(i,n);
    	}
    	return pattern;
    }	
}
