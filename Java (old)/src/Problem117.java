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
public class Problem117 {
	Problem117(){
		int n = 50;
		long[] a = new long[n+1];
		a[0] = a[1] = 1;
		a[2] = 2;
		a[3] = 4;
		for(int i = 4; i <= n; i++){
			a[i] = a[i-1] + a[i-2] + a[i-3] + a[i-4];
			System.out.println(a[i]);
		}
	}
}
