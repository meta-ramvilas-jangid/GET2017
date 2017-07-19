public class LargestDigit {
	int max=-1;           //contain largest digit value
	/**
	 * 
	 * @param x is argument in which find out largest digit
	 * @return largest digit of x
	 */
	int largestDigit(int x){
		if(x<0){
			throw new IllegalArgumentException();
		}
		int m=x%10;
		if(max<m){
			max=m;
		}
		if(x<10){
			return max;
		}
		return largestDigit(x/10);
	}
}
