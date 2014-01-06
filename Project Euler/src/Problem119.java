import java.util.ArrayList;
import java.util.Collections;

/*
The number 512 is interesting because it is equal to the sum of its digits raised to some power: 5 + 1 + 2 = 8, and 8^3 = 512. 
Another example of a number with this property is 614656 = 28^4.
We shall define an to be the nth term of this sequence and insist that a number must contain at least two digits to have a sum.
You are given that a2 = 512 and a10 = 614656.
Find a30.
*/
public class Problem119 {
	public Problem119(){
		ArrayList<Long> a = new ArrayList<Long>();
		long limit = (long)Math.pow(10,15);
		for(long b = 2; b < 100; b++){
			for(int e = 2; e > 0; e++){
				long p = (long)Math.pow(b,e);
				if(p > limit){
					break;
				}
				if(b == MyLib.SumDigits(p)){
					a.add(p);
					System.out.println(b + "^" + e + "=" + p);
				}
			}
		}
		Collections.sort(a);
		for(int i = 0; i < a.size(); i++){
			System.out.println((i+1) + " " + a.get(i));//248155780267521
		}
		
	}
}
