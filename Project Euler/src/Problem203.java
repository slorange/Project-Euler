import java.util.ArrayList;
import java.util.Collections;


public class Problem203 {

	int n = 51;
	long[][] a = new long[n][n];
	ArrayList<Long> b = new ArrayList<Long>();
	
	public Problem203(){		
		for(int i = 0; i < n; i++){
			a[i][0] = 1;
			for(int j = 1; j < i; j++){
				a[i][j] = a[i-1][j] + a[i-1][j-1];
			}
			a[i][i] = 1;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				if(!b.contains(a[i][j])){
					b.add(a[i][j]);
				}
			}
		}
		Collections.sort(b);
		
		long sum = 0;
		for(Long i : b){
			if(Squarefree(i)){
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	boolean Squarefree(Long n){
		for(long i = 2; i*i <= n; i++){
			if(n % (i*i) == 0){
				return false;
			}
		}
		return true;
	}

	void Print(){
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
