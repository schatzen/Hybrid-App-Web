package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class MyMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//The final field BaseCalc.PI cannot be assigned
        //BaseCalc.PI = 3.141592;
		System.out.println(BaseCalc.PI);
		
		//인터페이스= new 클래스()
		//   사용   =    생산
		BaseCalc calc = new BaseCalcImpl();
		
		int a = 10, b= 5,res;
		//인터페이스를 이용해서 객체기능을 사용
		res = calc.plus(a, b);
		System.out.printf("%d + %d = %d\n", a,b,res);
				
		
        
	}

}
