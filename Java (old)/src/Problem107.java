import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Problem107 {
	int n = 40;
	int[][] grid;/* = {{-1,16,12,21,-1,-1,-1},
					{16,-1,-1,17,20,-1,-1},
					{12,-1,-1,28,-1,31,-1},
					{21,17,28,-1,18,19,23},
					{-1,20,-1,18,-1,-1,11},
					{-1,-1,31,19,-1,-1,27},
					{-1,-1,-1,23,11,27,-1}};*/
	public Problem107(){
		try {
			grid = new int[n][n];
			Scanner s = new Scanner(new File("data/network.txt"));
			s.useDelimiter(",|\\n");
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					String str = s.next();
					if(str.equals("-")){
						grid[i][j] = -1;
					}
					else{
						grid[i][j] = Integer.parseInt(str);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int oldsum = 0;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(grid[i][j] > 0){
					oldsum += grid[i][j];
				}
			}
		}
		
		
		ArrayList<Edge> e = new ArrayList<Edge>();
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(grid[i][j] > 0){
					e.add(new Edge(i,j,grid[i][j]));
				}
			}
		}
		Collections.sort(e);
		Collections.reverse(e);
		System.out.println(e);
		
		for(int i = 0; i < e.size(); i++){
			Edge x = e.remove(i);
			grid[x.i][x.j] = -1;
			grid[x.j][x.i] = -1;
			if(!Connected()){
				e.add(i, x);
				grid[x.i][x.j] = x.v;
				grid[x.j][x.i] = x.v;
				System.out.println("Did not remove " + x);
				continue;
			}
			System.out.println("Removed " + x);
			i--;
		}
		
		int sum = 0;
		for(Edge i : e){
			sum += i.v;
		}
		System.out.println(oldsum + " - " + sum + " = " + (oldsum-sum));
	}
	
	class Edge implements Comparable<Edge>{
		int i,j,v;
		public Edge(int i, int j, int v){
			this.i = i;
			this.j = j;
			this.v = v;
		}
		
		public String toString(){
			return "("+i+","+j+")="+v;
		}

		public int compareTo(Edge e) {
			if(v > e.v) return 1;
			if(v < e.v) return -1;
			return 0;
		}
	}
	
	boolean Connected(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		return Connected(a);
	}
	
	boolean Connected(ArrayList<Integer> a){
		if(a.size() == n) return true;
		int current = a.get(a.size()-1);
	  	for(int i = 0; i < n; i++){
	  		if(i != current && grid[current][i] >= 0){ // look for link
  				if(!a.contains(i)){ // no cycle, recurse
	  				a.add(i);
	  				if(Connected(a)){
	  					return true;
	  				}
	  			}
	  		}
	  	}
	  	return false;
	}
	
	
	//alternate solution
	boolean RemoveCycles(ArrayList<Integer> a){
		int current = a.get(a.size()-1);
		int last = a.get(a.size()-1);
		if(a.size() > 1){
			last = a.get(a.size()-2);
		}
	  	for(int i = 0; i < n; i++){
	  		if(i != current && i != last && grid[current][i] >= 0){ // look for link
  				if(a.contains(i)){ // arraylist has a cycle
  					boolean found = false;
  					int max = 0;
  					int maxi = -1;
  					int maxj = -1;
  					int lasti = current;
  					System.out.print("Found cycle: ");
  					for(Integer j : a){
  						if(!found && j != i) continue;
  						found = true;
  						System.out.print(j+" ");
  						if(grid[j][lasti] > max){
  							max = grid[j][lasti];
  							maxi = lasti;
  							maxj = j;
  						}
  						lasti = j;
  					}
  					System.out.println();
  					System.out.println("Removing edge " + maxi + " " + maxj + " " + max);
  					System.out.println();
  					grid[maxi][maxj] = -1;
  					grid[maxj][maxi] = -1;
  					return true;
  				}
  				else{ // no cycle, recurse
	  				a.add(i);
	  				if(RemoveCycles(a)){
	  					return true;
	  				}
	  				a.remove(a.size()-1);
	  			}
	  		}
	  	}
	  	return false;
	}
}
