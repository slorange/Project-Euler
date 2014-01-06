import java.util.ArrayList;

/*
There are some prime values, p, for which there exists a positive integer, n, such that the expression n3 + n2p is a perfect cube.
For example, when p = 19, 83 + 82×19 = 123.
What is perhaps most surprising is that for each prime with this property the value of n is unique, and there are only four such primes below one-hundred.
How many primes below one million have this remarkable property?
*/

public class Problem131 {
	Problem131(){
		ArrayList<Long> cubes = new ArrayList<Long>();
		int p[] = MyLib.generatePrimes(1000000);
		int count = 0;
		for(int j = 1; j < 200; j++){
			long k = j*j*j;
			for(int i = 0; i < p.length; i++){
				int pi = p[i];
				long x = k*k*k + k*k*pi;
				long c = (long)Math.round(cubeRoot(x));
				if(c*c*c == x){
					System.out.println(k+"^3 + "+k+"^2*"+pi+" = "+c+"^3");
					count++;
					break;
				}
				//System.out.println(pi + " " + k + " " + x + " " + c);
			}
		}
		System.out.println(count);
	}
	
	public static double cubeRoot(double x) {  
		return Math.pow(x, 1.0/3);  
	} 
}
