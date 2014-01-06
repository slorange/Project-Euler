import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*The rules for writing Roman numerals allow for many ways of writing each number (see About Roman Numerals...). 
 * However, there is always a "best" way of writing a particular number.

For example, the following represent all of the legitimate ways of writing the number sixteen:

IIIIIIIIIIIIIIII
VIIIIIIIIIII
VVIIIIII
XIIIIII
VVVI
XVI

The last example being considered the most efficient, as it uses the least number of numerals.

The 11K text file, roman.txt (right click and 'Save Link/Target As...'), contains one thousand numbers written in 
valid, but not necessarily minimal, Roman numerals; that is, they are arranged in descending units and obey the 
subtractive pair rule (see About Roman Numerals... for the definitive rules for this problem).

Find the number of characters saved by writing each of these in their minimal form.

Note: You can assume that all the Roman numerals in the file contain no more than four consecutive identical units.
*/

public class Problem89 {
	public static int[] basen = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	public static String[] baser = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("data/roman.txt"));
		String r = "";
		int sum = 0;
		while((r = in.readLine()) != null){
			int n = Decimal(r);
			String r2 = Roman(n);
			int diff = r.length() - r2.length();
			sum += diff;
			System.out.println(r + " " + n + " " + r2 + " " + diff + " " + sum);
		}
		System.out.println();
		System.out.println(sum);
	}
	
	public static int Decimal(String r){
		int n = 0;
		int i = baser.length -1;
		while(r.length() > 0){
			if(r.startsWith(baser[i])){
				n += basen[i];
				r = r.substring(baser[i].length());
			}
			else{
				i--;
				if(i < 0){
					System.err.println("Error 1");
				}
			}
		}
		return n;
	}
	
	public static String Roman(int n){
		String s = "";
		int i = basen.length -1;
		while(n > 0){
			if(n >= basen[i]){
				n -= basen[i];
				s += baser[i];
			}
			else{
				i--;
				if(i < 0){
					System.err.println("Error 2");
				}
			}
		}
		return s;
	}
}
