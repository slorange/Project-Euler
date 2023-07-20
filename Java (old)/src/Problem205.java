import java.util.Arrays;

/*Peter has nine four-sided (pyramidal) dice, each with faces numbered 1, 2, 3, 4.
Colin has six six-sided (cubic) dice, each with faces numbered 1, 2, 3, 4, 5, 6.
Peter and Colin roll their dice and compare totals: the highest total wins. The result is a draw if the totals are equal.
What is the probability that Pyramidal Pete beats Cubic Colin? Give your answer rounded to seven decimal places in the 
form 0.abcdefg
*/

public class Problem205 {
	public static void main(String[] args) {
		int petern = (int) Math.pow(4, 9);
		int peter[] = new int[37];
		for(int i = 0; i < petern; i++){
			peter[sum(pad(Integer.toString(i, 4), 9))]++;
		}

		int colinn = (int) Math.pow(6, 6);
		int colin[] = new int[37];
		for(int i = 0; i < colinn; i++){
			colin[sum(pad(Integer.toString(i, 6), 6))]++;
		}
		int sum = 0;
		for(int i = 0; i < 37; i++){
			sum += colin[i];
			colin[i] = sum;
		}
		
		double chance = 0.0;
		for(int i = 1; i < 37; i++){
			chance += 1.0 * peter[i] * colin[i-1] / petern / colinn;
		}
		System.out.println(chance);
	}
	
	public static String pad(String s, int n){
		for(int i = s.length(); i < n; i++){
			s = '0' + s;
		}
		return s;
	}
	
	public static int sum(String s){
		int sum = 0;
		for(int i = 0; i < s.length(); i++){
			sum += s.charAt(i)-'0'+1;
		}
		return sum;
	}
}
