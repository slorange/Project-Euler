import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;


public class Problem204 {
	TreeSet<Integer> a = new TreeSet<Integer>();
	int n1 = 100;
	int n2 = 1000000000;
	int p[] = MyLib.generatePrimes(n1);
	
	Problem204(){		
		for(int i = 0; i < p.length; i++){
			System.out.print(p[i]+" ");
		}
		System.out.println();
		
		a.add(1);
		Helper(a);
		
		//for(Integer i : a){
		//	System.out.println(i);
		//}
		System.out.println(a.size());
	}
	
	void Helper(TreeSet<Integer> b){
		TreeSet<Integer> c = new TreeSet<Integer>();
		for(Integer i : b){
			for(int j = 0; j < p.length; j++){
				int x = i*p[j];
			  if(x > n2) break;
				if(!a.contains(x) && !c.contains(x)){
					c.add(x);
				}
			}
		}
		if(!c.isEmpty()){
			a.addAll(c);
			Helper(c);
		}
	}
}
