import java.util.SortedSet;
import java.util.TreeSet;


public class Problem357 {
	Problem357(){
		int n = 1000;
		SortedSet<Integer>[] factors = new SortedSet[n+1];
		for (int i = 1; i <= n; i++) {
	    	factors[i] = new TreeSet<Integer>();
	    	factors[i].add(1);
	    	factors[i].add(i);
		}
	    for (int i = 2; i * i <= n; i++) {
	        if (factors[i].size() == 2) {
	            for (int j = i; i * j <= n; j++) {
	            	factors[i*j].add(i);
	            	factors[i*j].add(j);
	            }
	        }
	    }

		for(int i = 1; i < n; i++){
        	System.out.println(i + " " + factors[i]);
		}
	}
}
