/*
A row of five black square tiles is to have a number of its tiles replaced with coloured oblong tiles chosen from red (length two), 
green (length three), or blue (length four).

If red tiles are chosen there are exactly seven ways this can be done.
If green tiles are chosen there are three ways.
And if blue tiles are chosen there are two ways.

Assuming that colours cannot be mixed there are 7 + 3 + 2 = 12 ways of replacing the black tiles in a row measuring five units in length.
How many different ways can the black tiles in a row measuring fifty units in length be replaced if colours cannot be mixed and at least 
one coloured tile must be used?
 */
public class Problem116 {
	Problem116(){
		int n = 50;
		long[] r = new long[n+1];
		r[0] = r[1] = 1;
		for(int i = 2; i <= n; i++){
			r[i] = r[i-1] + r[i-2];
		}
		long[] g = new long[n+1];
		g[0] = g[1] = g[2] = 1;
		for(int i = 3; i <= n; i++){
			g[i] = g[i-1] + g[i-3];
		}
		long[] b = new long[n+1];
		b[0] = b[1] = b[2] = b[3] = 1;
		for(int i = 4; i <= n; i++){
			b[i] = b[i-1] + b[i-4];
		}
		long sum = r[n]-1 + g[n]-1 + b[n]-1;
		System.out.println((r[n]-1) + " + " + (g[n]-1) + " + " + (b[n]-1)+" = "+sum);
	}
}
