package myutil;

public class MySingleton {

	//singleton : 객체를 1개만 생성해서 사용하자
	static MySingleton single = null;
	
	public static MySingleton getInstance() {
		
		if(single==null) single = new MySingleton();
		
		return single;
	}
	
	
	public MySingleton() {
		// TODO Auto-generated constructor stub
		System.out.println("--MySingleton()--");
	}
	
	public int hap(int n) {
		int sum = 0;
		for(int i=0;i<=n;i++) {
			sum += i;
		}
		return sum;
	}
	
}

