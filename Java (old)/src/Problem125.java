import java.util.ArrayList;

/*
The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.

There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, and the sum of these palindromes is 4164. 
Note that 1 = 0^2 + 1^2 has not been included as this problem is concerned with the squares of positive integers.

Find the sum of all the numbers less than 10^8 that are both palindromic and can be written as the sum of consecutive squares.
 */
public class Problem125 {
	int n = 100000000;
	int n2 = (int)Math.sqrt(n);
	int s[] = new int[n2];
	public Problem125(){
		for(int i = 0; i < n2; i++){
			s[i] = i*i;
		}
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 1; i < n2; i++){
			int sum = s[i];
			for(int j = i+1; j < n2; j++){
				sum += s[j];
				if(sum > n){
					break;
				}
				if(Palindrome(sum)){
					if(!a.contains(sum)){
						a.add(sum);
					}
					System.out.println(sum);
				}
			}
		}
		long sum = 0;
		for(Integer i : a){
			sum += i;
		}
		System.out.println(sum);//wrong: 2916867073
	}
	
	public boolean Palindrome(long n){
		String s = ""+n;
		for(int i = 0; i < s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-i-1)){
				return false;
			}
		}
		return true;
	}
}
