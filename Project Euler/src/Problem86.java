import java.util.ArrayList;


public class Problem86 {
	Problem86(){
		int n = 2000;
		ArrayList<MyLib.Triplet> a = MyLib.generateTriplets(n);
		int[] r = new int[n/2];
		for(MyLib.Triplet t : a){
			if(t.a >= n/2){
				break;
			}
		  if(t.b > 2*t.a) continue;
			r[t.a] += t.b/2 - (t.b-t.a);
			/*for(int i = 1; i < t.b && i < n/2; i++){
				int max = t.a;
				if(max < i) max = i;
				if(max < t.b-i) max = t.b-i;
			  if(max >= n/2) continue;
				r[max]++;
			}*/
		}
		int[] rsum = new int[n/2];
		int sum = 0;
		for(int i = 0; i < n/2; i++){
			sum += r[i];
			rsum[i] = sum;
			System.out.println(i + " " + sum);
			if(sum > n){
				break;
			}
		}
	}
}
