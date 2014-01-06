import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*

By using each of the digits from the set, {1, 2, 3, 4}, exactly once, and making use of the four arithmetic operations (+, -, *, /) and brackets/parentheses, it is possible to 
form different positive integer targets.

For example,

8 = (4 * (1 + 3)) / 2
14 = 4 * (3 + 1 / 2)
19 = 4 * (2 + 3) - 1
36 = 3 * 4 * (2 + 1)

Note that concatenations of the digits, like 12 + 34, are not allowed.

Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the maximum, and each of the numbers 1 to 28 can be obtained before
 encountering the first non-expressible number.

Find the set of four distinct digits, a < b < c < d, for which the longest set of consecutive positive integers, 1 to n, can be obtained, giving your answer as a string: abcd.
*/
public class Problem93 {

	Problem93(){
		int max = 0;
		String maxs = "";
		for(int a = 1; a < 10; a++){
			for(int b = a+1; b < 10; b++){
				for(int c = b+1; c < 10; c++){
					for(int d = c+1; d < 10; d++){
						int m = k(new int[]{a,b,c,d});
						String s = ""+a+""+b+""+c+""+d;
						System.out.println(s + " " + m);
						if(m > max){
							max = m;
							maxs = s;
						}
					}
				}
			}
		}
		
		System.out.println("Winner: " + maxs + " " + max);
	}
	
	int k(int o[]){
		SortedSet<Double> p = new TreeSet<Double>();
		for(int a = 1; a <= 4; a++){
			for(int b = 1; b <= 4; b++){
				if(b == a) continue;
				for(int c = 1; c <= 4; c++){
					if(c == a || c == b) continue;
					for(int d = 1; d <= 4; d++){
						if(d == c || d == a || d == b) continue;
						p.addAll(h(o[a-1],o[b-1],o[c-1],o[d-1]));
					}
				}
			}
		}
		int c = 1;
		for(double i : p){
			int j = (int)i;
			if(i == j && j > 0){
				if(j != c) break;
				c++;
			}
		}
		return c-1;
	}
	
	SortedSet<Double> h(double a2, double b2, double c2, double d2){
		SortedSet<Double> a = new TreeSet<Double>();
		a.add(a2);
		SortedSet<Double> b = new TreeSet<Double>();
		b.add(b2);
		SortedSet<Double> c = new TreeSet<Double>();
		c.add(c2);
		SortedSet<Double> d = new TreeSet<Double>();
		d.add(d2);
		SortedSet<Double> p = new TreeSet<Double>();
		//((ab)c)d
		p.addAll(g(g(g(a,b),c),d));
		//(ab)(cd)
		p.addAll(g(g(a,b),g(c,d)));
		//(a(bc))d
		p.addAll(g(g(a,g(b,c)),d));
		//a((bc)d)
		p.addAll(g(a,g(g(b,c),d)));
		//a(b(cd))
		p.addAll(g(a,g(b,g(c,d))));
		return p;
	}
	
	SortedSet<Double> g(Set<Double> a, Set<Double> b){
		SortedSet<Double> r = new TreeSet<Double>();
		for(Double j : a){
			for(Double k : b){
				for(int i = 1; i <= 4; i++){
					r.add(f(j,k,i));
				}
			}
		}
		return r;
	}
	
	double f(double x, double y, int func){
		switch(func){
			case 1:
				return x + y;
			case 2:
				return x - y;
			case 3:
				return x * y;
			case 4:
				return x / y;
		}
		return 0;
	}
}
