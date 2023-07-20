/*
Let f(N) be the number of points with integer coordinates that are on a circle passing through (0,0), (N,0),(0,N), and (N,N).
It can be shown that f(10000) = 36.
What is the sum of all positive integers N <= 10^11 such that f(N) = 420 ?
*/
public class Problem233 {
	/*public static void main(String[] args) {
		int sum = 0;
		for(int n = 2; n <= 10000; n+=2){//use even numbers, then we can start count at 4
			int count = 4;
			double rsquared = n*n/2; //(n/2)^2 + (n/2)^2
			for(int a = 1; a < Math.sqrt(rsquared/2); a++){
				//n*n/2 = a*a + b*b
				double b = Math.sqrt(rsquared - a*a);
				if(b == (int)b){
					System.out.println(n + " " + a + " " + b);
					count += 8;
				}
			}
			if(count >= 420){
				sum += n;
				System.out.println(count + " " + n + " " + sum);
			}
		}
	}*/
	
	public static void main(String[] args) {
		//since 420 is not divisible by 8, we need a 4 in there
		//that means N cannot be odd
		//looping for all a and b to add result to array of all N
		//we need n*n/2 = a*a + b*b so we have n = sqrt(2*(a*a+b*b))
		//so we look at perfect squares and have ps = 2*a*a + 2*b*b so we need b = sqrt(ps/2-a*a)
		
		
	}
}
