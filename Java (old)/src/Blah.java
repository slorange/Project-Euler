import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;


public class Blah {

	ArrayList<Pokemon> ps = new ArrayList<Pokemon>();
	Pokemon[] ps2;
	
	Blah(){
		try {
			Scanner s = new Scanner(new File("data/PokeData.txt"));
			s.useDelimiter("Posted Image|Moves to be wary of|Checks and Counters");
			while(s.hasNext()){
				ps.add(new Pokemon(s.next(),s.next(),s.next()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		for(Pokemon p : ps){
			p.findCounters();
			System.out.println(p + " " + p.listCounters());
		}
		
		Collections.sort(ps);
		Collections.reverse(ps);
		for(Pokemon p : ps){
			System.out.println(p + " " + p.strengths.size() + " " + p.listStrengths());
		}
		ps2 = new Pokemon[ps.size()];
		ps.toArray(ps2);
		
		System.out.println(ps.size());
		
		Team t = new Team("Tyranitar","Marowak","Blissey","Skarmory","Dusclops","Starmie");
		System.out.println(t + " " + t.strengths.size() + " " + t.notHandled());
		
		
		/*int best = 0;
		Team bestTeam = null;
		for(int i = 0; i < ps2.length; i++){
			System.out.println(i);
			Pokemon pi = ps2[i];
			for(int j = i+1; j < ps2.length; j++){
				Pokemon pj = ps2[j];
				for(int k = j+1; k < ps2.length; k++){
					Pokemon pk = ps2[k];
					for(int l = k+1; l < ps2.length; l++){
						Pokemon pl = ps2[l];
						for(int m = l+1; m < ps2.length; m++){
							Pokemon pm = ps2[m];
							for(int n = m+1; n < ps2.length; n++){
								Pokemon pn = ps2[n];
								Team t = new Team(new Pokemon[]{pi,pj,pk,pl,pm,pn});
								if(t.strengths.size() >= best){
									System.out.println(t + " " + t.strengths.size());
									best = t.strengths.size();
									bestTeam = t;
								}
							}
						}
					}
				}
			}
		}*/
		
	}
	

	int pnum = 0;
	class Pokemon implements Comparable<Pokemon>{
		ArrayList<String> skills = new ArrayList<String>();
		ArrayList<Pokemon> counters = new ArrayList<Pokemon>();
		String name, description, counterText;
		ArrayList<Pokemon> strengths = new ArrayList<Pokemon>();
		int num = 0;
		Pokemon(String d, String s, String c){
			ParseNameDesc(d);
			ParseSkills(s);
			counterText = c;
			num = pnum++;
		}
		
		void ParseNameDesc(String str){
			Scanner s = new Scanner(str);
			s.nextLine();
			name = s.nextLine();
			while(s.hasNextLine()){
				description += s.nextLine();
			}
		}
		
		void ParseSkills(String str){
			Scanner s = new Scanner(str);
			s.useDelimiter(",|\\n");
			while(s.hasNext()){
				skills.add(s.next());
			}
		}
		
		void findCounters(){
			for(Pokemon p : ps){
				if(p == this) continue;
				if(counterText.toLowerCase().contains((""+p).toLowerCase())){
					counters.add(p);
					p.addStrength(this);
				}
			}
		}
		
		void addStrength(Pokemon p){
			strengths.add(p);
		}
		
		public String toString(){
			return name;
		}
		
		public String listStrengths(){
			return ""+strengths;
		}
		
		public String listCounters(){
			return ""+counters;
		}

		public int compareTo(Pokemon p) {
			if(strengths.size() > p.strengths.size())
				return 1;
			if(strengths.size() < p.strengths.size())
				return -1;
			if(num > p.num){
				return 1;
			}
			if(num < p.num){
				return -1;
			}
			return 0;
		}
	}
	
	class Team{
		Pokemon p[] = new Pokemon[6];
		TreeSet<Pokemon> strengths = new TreeSet<Pokemon>();

		Team(String p1, String p2, String p3, String p4, String p5, String p6){
			this(new String[]{p1,p2,p3,p4,p5,p6});
		}
		
		Team(String s[]){
			for(int i = 0; i < ps2.length; i++){
				for(int j = 0; j < s.length; j++){
					if(ps2[i].name.equals(s[j])){
						p[j] = ps2[i];
					}
				}
			}
			StrengthInit();
		}
		
		Team(Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4, Pokemon p5, Pokemon p6){
			this(new Pokemon[]{p1,p2,p3,p4,p5,p6});
		}
		
		Team(Pokemon p[]){
			this.p = p;
			StrengthInit();
		}
		
		void StrengthInit(){
			for(int i = 0; i < p.length; i++){
				strengths.addAll(p[i].strengths);
			}
		}
		
		public ArrayList<Pokemon> notHandled(){
			ArrayList<Pokemon> p = new ArrayList<Pokemon>();
			for(int i = 0; i < ps2.length; i++){
				if(!strengths.contains(ps2[i])){
					p.add(ps2[i]);
				}
			}
			return p;
		}
		
		public String toString(){
			String s = "";
			for(int i = 0; i < 6; i++){
				s += p[i] + " ";
			}
			return s;
		}
	}
}
