
public class Problem121 {
	int n = 4;
	double[] a = new double[n];
	int win = (int)Math.ceil((n+1.0)/2);
	
	Problem121(){
		
		int sum = 0;
		int c = 0;
		System.out.println(helper(n,0));
		
		
		/*for(int i = 0; i < n; i++){
			a[i] = 1.0/(i+2);
			System.out.println(a[i]);
		}
		
		System.out.println(win);
		System.out.println(helper(0, win));
		System.out.println(11.0/120);*/
	}
	
	//returns number of ways to win
	double helper(int picksLeft, int numOfBluesSoFar){
		if(picksLeft < win-numOfBluesSoFar){
			return 0;
		}
		int numberOfDiscs = n+2 - picksLeft;
		if(numOfBluesSoFar >= win){
			int waysToWin = numberOfDiscs;
			for(int i = 1; i < picksLeft; i++){
				numberOfDiscs++;
				waysToWin *= numberOfDiscs;
			}
			System.out.println(picksLeft + " " + numOfBluesSoFar + " " + waysToWin);
			return waysToWin;
		}
		int sum = 0;
		System.out.println(picksLeft + " " + numOfBluesSoFar);
		sum += helper(picksLeft-1, numOfBluesSoFar+1);
		sum += (numberOfDiscs-1) * helper(picksLeft-1, numOfBluesSoFar);
		return sum;
	}
	
	/*double helper(int s, int n){
		if(n == 0){
			return 1;
		}
		double sum = 0;
		for(int i = s; i <= a.length-n; i++){
			sum = add(sum, a[i]*helper(i+1, n-1));
		}
		System.out.println(s + " " + n + " " + sum);
		return sum;
	}
	
	double add(double a, double b){
		return a+b-a*b;
	}*/
}
