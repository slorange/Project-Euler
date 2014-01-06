import java.util.Arrays;

public class risk {
	public static void main(String[] args) {
		//new Problem243();
		int n = 1000000;
		int n1 = 3;
		int n2 = 2;
		double a = 0;
		double b = 0;
		for(int i = 0; i < n; i++){
			int x[] = new int[n1];
			int y[] = new int[n2];
			for(int j = 0; j < n1; j++){
				x[j] = (int)(Math.random()*6+1);
			}
			for(int j = 0; j < n2; j++){
				y[j] = (int)(Math.random()*6+1);
			}
			Arrays.sort(x);
			Arrays.sort(y);
			if(x[n1-1] > y[n2-1]){
				a++;
			}
			if(n1 > 1 && n2 > 1){
				if(x[n1-2] > y[n2-2]){
					b++;
				}
			}
			/*for(int j = 0; j < n1; j++){
				System.out.print(x[j]+" ");
			}
			System.out.print("  ");
			for(int j = 0; j < n2; j++){
				System.out.print(y[j]+" ");
			}
			System.out.println();*/
		}
		System.out.println((a/n*100)+"% "+(b/n*100)+"%");
	}
}
