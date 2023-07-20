import java.util.ArrayList;

@SuppressWarnings("serial")
public class LongInt extends ArrayList<Integer>{
	
	public LongInt(){
		
	}
	
	public LongInt(int n){
		add(n);
	}
	
	public LongInt(String s){
		int len = s.length();
		for(int i = 0; i < len; i++){
			char c = s.charAt(len - i - 1);
			if(c >= '0' && c <= '9'){
				add(c - '0');
			}
		}
	}
	
	public LongInt(LongInt l){
		for(int i = 0; i < l.size(); i++){
			add(l.get(i));
		}
	}
	
	public LongInt(ArrayList<Integer> a){
		new ArrayList<Integer>(a);
	}
	
	public LongInt deepCopy(LongInt l){
		clear();
		for(int i = 0; i < l.size(); i++){
			add(l.get(i));
		}
		return this;
	}
	
	public Integer get(int i){
		try{
			return super.get(i);
		}
		catch(IndexOutOfBoundsException e){
			return 0;
		}
	}
	
	public int length(){
		return size();
	}
	
	public String toString(){
		StringBuilder rtn = new StringBuilder();
		for(int i = size()-1; i >= 0; i--)
			rtn.append(get(i));
		return rtn.toString();
	}
	
	public LongInt add(LongInt n2){
		LongInt sum = add(this, n2);
		this.deepCopy(sum);
		return this;
	}

	public static LongInt add(LongInt n1, LongInt n2){
		if(n1.size() < n2.size())
			return add(n2, n1);
		LongInt r = new LongInt();
		int carry = 0;
		for(int i = 0; i < n1.length(); i++){
			int sum = n1.get(i) + n2.get(i) + carry;
			carry = sum / 10;
			r.add(sum % 10);
		}
		if(carry > 0)
			r.add(carry);
		return r;
	}
	
	public LongInt mult(LongInt n2){
		LongInt sum = mult(this, n2);
		this.deepCopy(sum);
		return this;
	}
	
	public static LongInt mult(LongInt n1, LongInt n2){
		if(n1.size() < n2.size())
			return mult(n2, n1);
		LongInt r = new LongInt();
		for(int i = 0; i < n2.size(); i++){
			r.add(mult(n1, n2.get(i)).padEnd(i));
		}
		return r;
	}
	
	public LongInt mult(int n2){
		LongInt sum = mult(this, n2);
		this.deepCopy(sum);
		return this;
	}
	
	public static LongInt mult(LongInt n1, int n2){
		LongInt r = new LongInt();
		int carry = 0;
		for(int i = 0; i < n1.length(); i++){
			int prod = n1.get(i) * n2 + carry;
			carry = prod / 10;
			r.add(prod % 10);
		}
		while(carry > 0){
			r.add(carry % 10);
			carry = carry / 10;
		}
		return r;
	}
	
	private LongInt padEnd(int n){
		for(int i = 0; i < n; i++)
			add(0,0);
		return this;
	}
	
	public LongInt pow(int n2){
		LongInt sum = pow(this, n2);
		this.deepCopy(sum);
		return this;
	}
	
	public static LongInt pow(LongInt n1, int n2){
		LongInt r = new LongInt(1);
		for(int i = 0; i < n2; i++){
			r.mult(n1);
		}
		return r;
	}
}
