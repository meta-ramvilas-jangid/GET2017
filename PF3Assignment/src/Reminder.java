public class Reminder {
	/**
	 * @param x divisor
	 * @param y dividend
	 * @return  reminder of x and y as x%y
	 */
	int rem(int x, int y){
		if(y<=0 || x<0){
			throw new IllegalArgumentException();
		}
		if(y>x){
			return x;
		}
		if(y==x){
			return 0;
		}
		x=x-y;
		return rem(x,y);
	}
}
