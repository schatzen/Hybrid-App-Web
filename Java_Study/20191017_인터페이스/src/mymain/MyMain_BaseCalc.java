package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class MyMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BaseCalc.PI = 3.141592;
		System.out.println("BaseCalc.PI");
		// 읽기는 가능! 왜냐!public 생략되어있어서 다른 package에서도 값 바꾸지만 않으면 에러 안뜸

		// 인터페이스 = new 클래스();
		// 사용 생산
		BaseCalc bc = new BaseCalcImpl();

		int a = 5, b = 10, res;

		res = bc.minus(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);

	}

}