import java.util.Arrays;

public class Problem243 {
	public Problem243(){
		int a = 10000;
		int n = 1;
		int p[] = MyLib.generatePrimes(a);
		
		for(int i = 0; i < p.length; i++){
			n *= p[i];
			if(n > p.length){
				break;
			}
			int x = -Arrays.binarySearch(p, n) - (i+1);
			int y = n - 1;
			System.out.println(n + " " + x + "/" + y);
		}
	}
}
