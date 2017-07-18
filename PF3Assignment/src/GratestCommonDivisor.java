public class GratestCommonDivisor {
	/**
	 * @param x is disior
	 * @param y is divident
	 * @return gratest common divisior of x and y
	 */
	int gcd(int x, int y){
		if(x<=0 || y<=0){
			throw new IllegalArgumentException();
		}
		if(x==y){
			return x;
		}
		if(x>y){
			return gcd(x-y, y);
		}else{
			return gcd(x,y-x);
		}
	}
}
