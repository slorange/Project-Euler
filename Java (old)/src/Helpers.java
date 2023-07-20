
public class Helpers {
	public static boolean pandigital19(String n){
		boolean found[] = new boolean[10];
		for(int i = 0; i < n.length(); i++){
			found[n.charAt(i)-'0'] = true;
		}
		boolean rtn = true;
		for(int i = 1; i <= 9; i++){
			rtn &= found[i];
		}
		return rtn;
	}
	
	public static boolean isPalindrome(String s){
		int l = s.length();
		for(int i = 0; i < l/2; i++){
			if(s.charAt(i) != s.charAt(l - i-1))
				return false;
		}
		return true;
	}
	
	public static int numberOfFactors(int n){
		if(n == 1)
			return 1;
		int num = 2;
		for(int i = 2; i < Math.sqrt(n); i++){
			if(n % i == 0)
				num += 2;
		}
		int r = (int)(Math.sqrt(n));
		if(r * r == n)
			if(n % r == 0)
				num++;
		return num;
	}
	
	//takes a number, returns length of chain
	public static int Collatz(long n){
		//n -> n/2 (n is even)
		//n -> 3n + 1 (n is odd)
		if(n <= 1){
			//System.out.println(n + " <= 1");
			return 1;
		}
		if(n % 2 == 0){
			//System.out.println(n + " is even");
			return Collatz(n/2)+1;
		}
		else{
			//System.out.println(n + " is odd");
			return Collatz(3*n+1)+1;
		}
	}
}
