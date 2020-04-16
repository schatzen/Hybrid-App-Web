package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;


public class MyMain_상속 {

	static void use_basecalc(BaseCalc bc) {
		//                   BaseCalc bc = ac;  
		//Ctrl + Shift + o : 코드최적화
		System.out.println("--only BaseCalc만 사용--");
		int a = 10,b=5,res;
		res = bc.minus(a, b);
		System.out.printf("use_basecalc : %d - %d = %d\n",
				                           a,  b,   res);
		//res = bc.hap(a);
		
	}
	
	static void use_object(Object ob) {
		//                 up-casting(사용영역 축소)
		//                 Object ob = ac;
		
		int n = 10,res;
		// down-casting(사용영역을 확장)
		res = ((AdvanceCalc)ob).hap(n);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=10,y=3,res;
		
		AdvanceCalc ac  = new AdvanceCalc();
		
		//use_basecalc
		use_basecalc(ac);
		
		use_object(ac);
				
		
		System.out.println("---main---");
		
		res = ac.plus(x, y);
		System.out.printf("%d + %d = %d\n",x,y,res);
		
		System.out.println(ac.toString());
		
		res = ac.hap(x);
		System.out.printf("%d까지의 합=%d\n",x,res);
		
		//
		Object ob = ac;
		
		
		
		//down-casting주의사항: 
		BaseCalc bc1 = new BaseCalc();//
		//객체내에 AdvanceCalc기능은 없다.
		//AdvanceCalc ac1 = (AdvanceCalc)bc1;
		
		
		
		
		
	}

}
