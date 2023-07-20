import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class MyLib {
	
	static class Triplet implements Comparable<Triplet>{
		int a;
		int b;
		int c;
		Triplet(int a, int b, int c){
			if(a < b){
				this.a = a;
				this.b = b;
			}
			else{
				this.a = b;
				this.b = a;
			}
			this.c = c;
		}
		public String toString(){
			return a + " " + b + " " + c;
		}

		public int compareTo(Triplet o) {
			if(o.a > this.a){
				return -1;
			}
			if(o.a < this.a){
				return 1;
			}
			return 0;
		}
	}
	
	//generates all Pythagorean Triplets up to cap
	//limit is java heap space around 15,000,000 which takes around 3 seconds
	static ArrayList<Triplet>  generateTriplets(int cap){
		//TODO: make primitive version (primitive if and only if m and n are coprime and m - n is odd)
		ArrayList<Triplet> list = new ArrayList<Triplet>();
		for(int m = 1; m*m < cap; m++){
			for(int n = 1; n < m; n++){
				int a = m*m-n*n;
				int b = 2*m*n;
				int c = m*m+n*n;
			  if(c > cap) break;
				list.add(new Triplet(a,b,c));
			}
		}
		Collections.sort(list);
		return list;
	}
	
	//upper limit from heap space is ~175,000,000
	//can save space by removing even elements from array
	static int [] generatePrimes(int max) {
	    boolean[] isComposite = generateComposites(max);
	    int numPrimes = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) numPrimes++;
	    }
	    int [] primes = new int [numPrimes];
	    int index = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) primes [index++] = i;
	    }
	    return primes;
	}
	
	//upper limit from heap space is ~175,000,000
	//can save space by removing even elements from array
	static boolean [] generateComposites(int max) {
	    boolean[] isComposite = new boolean[max + 1];
	    for (int i = 2; i * i <= max; i++) {
	        if (!isComposite [i]) {
	            for (int j = i; i * j <= max; j++) {
	                isComposite [i*j] = true;
	            }
	        }
	    }
	    return isComposite;
	}
	
	static long powerMod(long base, long exp, long mod){
		return powerMod(new BigInteger(""+base), exp, new BigInteger(""+mod)).longValue();
	}
	
	static BigInteger powerMod(BigInteger base, long exp, BigInteger mod){
		int n = (int)log2(exp);
		BigInteger[] a = new BigInteger[n+1];
		a[0] = base.mod(mod);
		for(int i = 1; i <= n; i++){
			a[i] = a[i-1].pow(2).mod(mod);
		}
		BigInteger ans = new BigInteger("1");
		for(int i = n; i >= 0; i--){
			long p = (long)Math.pow(2, i);
			if(exp >= p){
				exp -= p;
				ans = ans.multiply(a[i]);
			}
		}
		return ans.mod(mod);
	}
	
	static double log2(double num){
		return (Math.log(num)/Math.log(2));
	}
	
	static long SumDigits(long n){
		int sum = 0;
		while(n > 0){
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
}
