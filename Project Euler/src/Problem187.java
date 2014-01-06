import java.util.ArrayList;

/*
A composite is a number containing at least two prime factors. For example, 15 = 3 × 5; 9 = 3 × 3; 12 = 2 × 2 × 3.
There are ten composites below thirty containing precisely two, not necessarily distinct, prime factors: 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
How many composite integers, n < 10^8, have precisely two, not necessarily distinct, prime factors?
*/
public class Problem187 {
	int n = 100000000;
	ArrayList<Integer> a = new ArrayList<Integer>();
	
	public Problem187(){
		a.add(2);
		x:for(int i = 3; i < n/2; i+=2){
			for(Integer j : a){
				if(i % j == 0){
					continue x;
				}
				if(j > Math.sqrt(i)){
					break;
				}
			}
			a.add(i);
		}
		System.out.println(a.size() + " primes smaller than " + (n/2));
		
		Integer b[] = new Integer[a.size()];
		a.toArray(b);
		a.clear();
		int c = 0;
		for(int i = 0; b[i] < Math.sqrt(n); i++){
			for(int j = i; j < b.length; j++){
				int p = b[i]*b[j];
				if(p >= n){
					break;
				}
				//System.out.println(p);
				c++;
			}
		}
		System.out.println("Answer: " + c);
	}
}
