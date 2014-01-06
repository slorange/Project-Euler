/*The Fibonacci sequence is defined by the recurrence relation:

    Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.

It turns out that F541, which contains 113 digits, is the first Fibonacci number for which the last nine digits 
are 1-9 pandigital (contain all the digits 1 to 9, but not necessarily in order). And F2749, which contains 575 
digits, is the first Fibonacci number for which the first nine digits are 1-9 pandigital.

Given that Fk is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 
pandigital, find k.
*/

public class Problem104 {
	public static void main(String[] args) {
		long s1 = 1, s2 = 1, e1 = 1, e2 = 1;
		long max = (long)Math.pow(10,15);
		int i = 2;
		while(!PandigitalStart(""+s2) || !PandigitalEnd(""+e2)){
			Long s3 = s1 + s2;
			if(s3 > max){
				s3 /= 10;
				s2 /= 10;
				s1 /= 10;
			}
			s1 = s2;
			s2 = s3;
			Long e3 = e1 + e2;
			if(e3 > max){
				e3 %= max;
			}
			e1 = e2;
			e2 = e3;
			i++;
		}
		System.out.println(i);
	}
	
	public static boolean PandigitalStart(String n){
		String s = n.substring(0,Math.min(n.length(), 9));
		return Helpers.pandigital19(s);
	}
	
	public static boolean PandigitalEnd(String n){
		String s = n.substring(Math.max(0, n.length()-9));
		return Helpers.pandigital19(s);
	}
}
