/*
A row measuring seven units in length has red blocks with a minimum length of three units placed on it, such that any two red blocks 
(which are allowed to be different lengths) are separated by at least one black square. There are exactly seventeen ways of doing this.
						
How many ways can a row measuring fifty units in length be filled?

NOTE: Although the example above does not lend itself to the possibility, in general it is permitted to mix block sizes. 
For example, on a row measuring eight units in length you could use red (3), black (1), and red (4).
*/
public class Problem114 {
	public Problem114(){
		int n = 50;
		long[] a = new long[n+1];
		a[0] = a[1] = a[2] = 1;
		for(int i = 3; i <= n; i++){
			a[i] = a[i-1];//black first block
			for(int j = 3; j < i; j++){//size of red block to start with
				a[i] += a[i-j-1];
			}
			a[i]++;//full red
			System.out.println(i + " " + a[i]);
		}
	}
}
