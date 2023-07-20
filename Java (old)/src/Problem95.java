import java.util.ArrayList;

/*

The proper divisors of a number are all the divisors excluding the number itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. 
As the sum of these divisors is equal to 28, we call it a perfect number.

Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper divisors of 284 is 220, forming a chain of two numbers. 
For this reason, 220 and 284 are called an amicable pair.

Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:
12496 -> 14288 -> 15472 -> 14536 -> 14264 (-> 12496 -> ...)
Since this chain returns to its starting point, it is called an amicable chain.

Find the smallest member of the longest amicable chain with no element exceeding one million.
*/
public class Problem95 {

	int n = 1000000;
	int a[] = new int[n+1];
	
	public Problem95(){
		for(int i = 0; i <= n; i++){
			double s = Math.sqrt(i);
			a[i] = 1;
			for(int j = 2; j <= s; j++){
				if(i % j == 0){
					a[i] += j;
					if(j != s){
						a[i] += i/j;
					}
				}
			}
		}
		System.out.println("Done step one");
		
		int LongestChain = 0;
		int StartingPoint = 0;
		
		for(int i = 0; i <= n; i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int current = i;
			int c = 0;
			while(!list.contains(current) && current <= n){
				c++;
				list.add(current);
				current = a[current];
			}
			if(c > LongestChain && current == i){
				LongestChain = c;
				StartingPoint = i;
				System.out.println(i + " " + c);
			}
		}
	}

}
