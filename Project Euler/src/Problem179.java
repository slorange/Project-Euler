/*Find the number of integers 1 < n < 10^7, for which n and n + 1 have the same number of positive divisors. 
 * For example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.
 */
public class Problem179 {
	int n = 10000000;
	int a[] = new int[n+2];
	
	public Problem179(){
		for(int i = 1; i <= n; i++){
			for(int j = i; j <= n; j+=i){
				a[j]++;
			}
		}
		System.out.println("Done step one");
		int c = 0;
		for(int i = 2; i < n; i++){
			if(a[i] == a[i+1]){
				c++;
				//System.out.println(i + " " + (i+1) + " " + a[i]);
			}
		}
		System.out.println(c);
	}
}
