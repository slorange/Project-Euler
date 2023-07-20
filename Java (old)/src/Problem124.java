import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*

The radical of n, rad(n), is the product of distinct prime factors of n. For example, 504 = 23 × 32 × 7, so rad(504) = 2 × 3 × 7 = 42.
If we calculate rad(n) for 1 <= n <= 10, then sort them on rad(n), and sorting on n if the radical values are equal, we get:

Let E(k) be the kth element in the sorted n column; for example, E(4) = 8 and E(6) = 9.
If rad(n) is sorted for 1 <= n <= 100000, find E(10000).

*/
public class Problem124 {
	public Problem124(){
		int n = 100000;
		Pair[] p = new Pair[n+1];
		p[0] = new Pair(0,0);
		for(int i = 1; i <= n; i++){
			Set<Integer> s = PrimeFactorizaion(i);
			p[i] = new Pair(i,1);
			for(Integer j : s){
				p[i].value *= j;
			}
			System.out.println(p[i]);
		}
		Arrays.sort(p);
		/*for(int i = 1; i <= n; i++){
			System.out.println(i + " " + p[i]);
		}*/
		System.out.println(p[10000].key);
	}
	
	public Set<Integer> PrimeFactorizaion(int n){
		Set<Integer> a = new TreeSet<Integer>();
		for(int j = 2; j <= Math.sqrt(n); j++){
			if(n % j == 0){
				a.add(j);
				a.addAll(PrimeFactorizaion(n/j));
				return a;
			}
		}
		a.add(n);
		return a;
	}
	
	class Pair implements Comparable<Pair>{
		int key, value;
		Pair(int k, int v){
			key = k;
			value = v;
		}
		
		public String toString(){
			return key + " " + value;
		}

		public int compareTo(Pair b) {
			if(value > b.value)
				return 1;
			if(value < b.value)
				return -1;
			return 0;
		}
	}
}
