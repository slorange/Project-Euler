/*
Working from left-to-right if no digit is exceeded by the digit to its left it is called an increasing number; for example, 134468.
Similarly if no digit is exceeded by the digit to its right it is called a decreasing number; for example, 66420.
We shall call a positive integer that is neither increasing nor decreasing a "bouncy" number; for example, 155349.
As n increases, the proportion of bouncy numbers below n increases such that there are only 12951 numbers below one-million that are not bouncy and 
only 277032 non-bouncy numbers below 10^10.
How many numbers below a googol (10^100) are not bouncy?
*/
public class Problem113 {
	Problem113(){
		
		long sum = 0;
		for(int x = 1; x <= 100; x++){
			long[] a = Increasing(x);
			long[] b = Decreasing(x);
			long ssum = 0;
			for(int i = 0; i < 10; i++){
				ssum += a[i];
			}
			for(int i = 0; i < 10; i++){
				ssum += b[i];
			}
			ssum = ssum-9;
			System.out.println(x + " " + ssum);
			sum += ssum;
		}
		System.out.println("Total: " + sum);
	}
	
	long[] Increasing(int n){
		if(n <= 1){
			return new long[]{0,1,1,1,1,1,1,1,1,1};
		}
		long[] a = Increasing(n-1);
		long[] b = new long[10];
		for(int i = 9; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				b[i] += a[j];
			}
		}
		return b;
	}
	
	long[] Decreasing(int n){
		if(n <= 1){
			return new long[]{0,1,1,1,1,1,1,1,1,1};
		}
		long[] a = Decreasing(n-1);
		long[] b = new long[10];
		for(int i = 0; i < 10; i++){
			for(int j = i; j < 10; j++){
				b[i] += a[j];
			}
		}
		return b;
	}
}
