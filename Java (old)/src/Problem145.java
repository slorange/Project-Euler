/*Some positive integers n have the property that the sum [ n + reverse(n) ] consists entirely of odd (decimal) digits. 
 * For instance, 36 + 63 = 99 and 409 + 904 = 1313. We will call such numbers reversible; so 36, 63, 409, and 904 are 
 * reversible. Leading zeroes are not allowed in either n or reverse(n).
There are 120 reversible numbers below one-thousand.
How many reversible numbers are there below one-billion (10^9)?
*/
public class Problem145 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 10; i < 100000000; i++){
			if(i % 1000000 == 0){
				System.out.println("m" + i);
			}
			if(i % 10 == 0){
				continue;
			}
			int j = reverse(i);
			if(i%10 <= j%10){
				continue;
			}
			if(allodd(i + j)){
				System.out.println(i);
				count+=2;
			}
		}
		System.out.println(count);
	}
	
	/*public static boolean reversable(int n){
		String s = ""+n;
		for(int i = 0; i < s.length()/2; i++){
			int sum = s.charAt(i) - '0' + s.charAt(s.length()-i-1) - '0';
			if(sum > 9 || sum % 2 == 0){
				return false;
			}
		}
		if(s.length() % 2 != 0 && (s.charAt(s.length()/2) - '0') % 2 == 0){
			return false;
		}
		return true;
	}*/
	
	public static boolean allodd(int n){
		while(n > 0){
			if((n%10)%2 == 0){
				return false;
			}
			n /= 10;
		}
		return true;
	}
	
	public static int reverse(int n){
		return Integer.parseInt(reverse(""+n));
	}
	
	public static String reverse(String s){
		String s2 = "";
		for(int i = 0; i < s.length(); i++){
			s2 = s.charAt(i) + s2;
		}
		return s2;
	}
}
