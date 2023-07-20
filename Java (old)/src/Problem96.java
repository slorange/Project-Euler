import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*The 6K text file, sudoku.txt (right click and 'Save Link/Target As...'), contains fifty different Su Doku puzzles ranging in difficulty, 
 * but all with unique solutions (the first puzzle in the file is the example above).

By solving all fifty puzzles find the sum of the 3-digit numbers found in the top left corner of each solution grid; for example, 483 is the 
3-digit number found in the top left corner of the solution grid above.
*/
public class Problem96 {

	int[][] grid = new int[9][9];
	public Problem96(){
		try {
			Scanner s = new Scanner(new File("data/sudoku.txt"));
			int sum = 0;
			while(s.hasNextLine()){
				String line = s.nextLine();
				System.out.println(line);
				for(int i = 0; i < 9; i++){
					line = s.nextLine();
					for(int j = 0; j < 9; j++){
						grid[i][j] = line.charAt(j) - '0';
					}
					System.out.println(line);
				}
				int ans = SolveSudoku();
				System.out.println(ans);
				sum += ans;
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//returns 3-digit number found in the top left corner of the solution
	int SolveSudoku() throws Exception{
		boolean p = true;
		while(p){
			p = Progress();
		}
		if(!Solved()){
			//save grid
			int[][] backupGrid = Copy(grid);
			int a = 0, b = 0;
			x:for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(grid[i][j] == 0){
						a = i;
						b = j;
						break x;
					}
				}
			}
			int[] v = possibleValues(a,b);
			for(int i = 1; i <= 9; i++){
				if(v[i] > 0){
					continue;
				}
				//make a guess
				grid[a][b] = i;
				//System.out.println("Guessing " + i + " at (" + a + "," + b + ")");
				//PrintGrid();
				try{
					return SolveSudoku();
				} catch (Exception e) {
					//try next i
					grid = Copy(backupGrid);
				}
			}
			throw new Exception("No possible values");
		}
		
		System.out.println("Fixed");
		PrintGrid();
		return grid[0][0]*100 + grid[0][1]*10 + grid[0][2];
	}
	
	boolean Progress() throws Exception{
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(SolveCell(i,j) > 0){
					return true;
				}
			}
		}
		return false;
	}
	
	//returns -1 if already solved, 0 if it failed to solve
	int SolveCell(int a, int b) throws Exception{
		if(grid[a][b] != 0){
			return -1;
		}
		
		int[] v = possibleValues(a,b);
		int val = 0;
		for(int i = 1; i <= 9; i++){
			if(v[i] == 0){
				if(val == 0){
					val = i;
				}
				else{
					return 0;
				}
			}
		}
		if(val == 0){
			throw new Exception("No possible values");
		}
		grid[a][b] = val;
		return val;
	}
	
	int[] possibleValues(int a, int b){
		int[] v = new int[10];
		CheckRow(a, v);
		CheckColumn(b, v);
		CheckMiniGrid(a, b, v);
		return v;
	}
	
	void CheckRow(int a, int[] v){
		for(int i = 0; i < 9; i++){
			v[grid[a][i]] = 1;
		}
	}
	
	void CheckColumn(int a, int[] v){
		for(int i = 0; i < 9; i++){
			v[grid[i][a]] = 1;
		}
	}
	
	void CheckMiniGrid(int a, int b, int[] v){
		a /= 3;
		b /= 3;
		for(int i = 0; i < 9; i++){
			int row = a*3 + i/3;
			int column = b*3 + i%3;
			v[grid[row][column]] = 1;
		}
	}
	
	boolean Solved(){
		for(int i = 0; i < 9; i++){
			if(SumRow(i) != 45){
				return false;
			}
		}
		for(int i = 0; i < 9; i++){
			if(SumColumn(i) != 45){
				return false;
			}
		}
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(SumMiniGrid(i, j) != 45){
					return false;
				}
			}
		}
		return true;
	}
	
	int SumRow(int a){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			sum += grid[a][i];
		}
		return sum;
	}
	
	int SumColumn(int a){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			sum += grid[i][a];
		}
		return sum;
	}
	
	int SumMiniGrid(int a, int b){
		int sum = 0;
		for(int i = 0; i < 9; i++){
			int row = a*3 + i/3;
			int column = b*3 + i%3;
			sum += grid[row][column];
		}
		return sum;
	}
	
	void PrintGrid(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	int[][] Copy(int [][] g){
		int[][] c = new int[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				c[i][j] = g[i][j];
			}
		}
		return c;
	}
}
