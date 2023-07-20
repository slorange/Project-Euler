import java.util.ArrayList;
import java.util.Hashtable;

/*

Consider quadratic Diophantine equations of the form:

x^2 – Dy^2 = 1

For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.

It can be assumed that there are no solutions in positive integers when D is square.

By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:

3^2 – 2×2^2 = 1
2^2 – 3×1^2 = 1
9^2 – 5×4^2 = 1
5^2 – 6×2^2 = 1
8^2 – 7×3^2 = 1

Hence, by considering minimal solutions in x for D <= 7, the largest x is obtained when D=5.

Find the value of D <= 1000 in minimal solutions of x for which the largest value of x is obtained.
*/
public class Problem66 {
	long cap = 1000000;
	Hashtable<Long, Long> squares = new Hashtable<Long, Long>();
	
	public Problem66(){
		for(long i = 1; i <= cap; i++){
			squares.put(i, i*i);
		}
		
		//x^2 = 1 + Dy^2
		//x = root(1+Dy^2)
		for(long d = 2; d <= 1000; d++){
			if(!isSquare(d)){
				for(long y = 1; y > 0; y++){
					if(isSquare(1+d*y*y)){
						long x = (long)Math.sqrt(1+d*y*y);
						System.out.println(x + "^2 - " + d + "*" + y + "^2 = 1");
						break;
					}
				}
			}
		}
	}
	
	private boolean isSquare(long n){
		if(squares.contains(n))
			return true;
		if(n > cap){
			System.out.println("Error");
			System.exit(1);
		}
		return false;
		//long s = (long)Math.sqrt(n);
		//return s*s == n;
	}

}
