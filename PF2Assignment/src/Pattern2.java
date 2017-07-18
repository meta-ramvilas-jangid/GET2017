public class Pattern2 {
	/**
	 * space method take two arguments
	 * @param row particular row in pattern
	 * @param n maximum numeric value
	 * @return string of space
	 */
	String space(int row, int n){
		if(row>n){
    		       return null;    //particular row not present in this pattern
    	        }
		String pattern="";	
		for(int j=0; j<(row-1); j++)
			{
			pattern=pattern+" ";
			}
		return pattern;
	}
	/**
	 * numeric function take 2 arguments
	 * @param row particular row in pattern
	 * @param n maximum numeric value in pyramind
	 * @return String of numbers
	 */
	String number(int row, int n){
		if(row>n){
    		        return null;    //particular row not present in this pattern
    	        }
		String pattern="";
		int count=1;
		for(int j=0; j<=(n-row);j++){
			pattern=pattern+count;
			count++;
		}
		return pattern;
	}
	/**
        * print function take one argument
        * @param n maximum numeric value of pattern
        * @return String array that contain every row of pattern
        */
	String[] print(int n){
    	String pattern[]=new String[n];
    	for(int i=1; i<=n; i++){
    		pattern[i-1]=space(i,n);
    		pattern[i-1]+=number(i,n);
    	}
    	return pattern;
    }	
}
