/*

Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five coins can separated into piles in 
exactly seven different ways, so p(5)=7.
OOOOO
OOOO   O
OOO   OO
OOO   O   O
OO   OO   O
OO   O   O   O
O   O   O   O   O

Find the least value of n for which p(n) is divisible by one million.

1 1
2 2 = 1 + 1
3 3 = 2 + 1
4 5 = 3 + 2
5 7 = 5 + 2
6 10 = 7 + 3
7 13 = 10 + 3
8 17 = 13 + 4
9 21 = 17 + 4

*/
public class Problem78 {
	public Problem78(){
		/*long n = 1;
		long a = 0;
		for(int i = 1; i < 100; i++){
			if(i % 2 == 0){
				a++;
			}
			n += a;
			//int y = (i+1)*i/4 - (i-3)/4; //got this with trial and error
			// y = 1/4 * i^2 + 1/4 * i - 1/4 * i + 3/4 
			// y = 1/4 * i^2 + 3/4
			int y = i*i/4 + 1;
			System.out.println(i + "\t" + n + "\t" + y);
		}*/
		int step = 1000000;
		for(long y = step; y > 0; y += step){
			long x = (int)Math.sqrt(4*(y - 1));
			if(y % 1000000000 == 0)
				System.out.println(x + " " + y);
			if(y == x*x/4 + 1){
				System.out.println(x + " " + y);
				break;
			}
		}
		
	}
}
