/*
Let p_n be the nth prime: 2, 3, 5, 7, 11, ... and let r be the remainder when (pn-1)^n + (pn+1)^n is divided by pn^2.

For example, when n = 3, p3 = 5, and 4^3 + 6^3 = 280 = 5 mod 25.

The least value of n for which the remainder first exceeds 10^9 is 7037.

Find the least value of n for which the remainder first exceeds 10^10.
*/
public class Problem123 {
	public Problem123(){
		double limit = Math.pow(10,10);
		int limit2 = 1000000;
		int[] p = MyLib.generatePrimes(limit2);
		for(int i = 0; i < limit2; i++){
			long n = i+1;
			long pn = p[i];
			long mod = pn*pn;
			long a = MyLib.powerMod(pn-1, n, mod);
			long b = MyLib.powerMod(pn+1, n, mod);
			long r = (a + b) % mod;
			if(r > limit){
				System.out.println(n + " " + pn + " " + mod + " " + a + " " + b + " " + r);
				break;
			}
		}
	}
}
