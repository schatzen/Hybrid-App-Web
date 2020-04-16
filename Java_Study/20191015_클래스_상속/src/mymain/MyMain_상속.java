package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_상속 {

	static void use_basecalc(BaseCalc bc) {
		// BaseCalc bc = ac;
		// up-casting (자동형변환 / 사용영역을 축소)

		System.out.println("--only BaseCalc만 사용--");
		int a = 10, b = 5, res;
		res = bc.minus(a, b);
		System.out.printf("use_basecalc : %d - %d = %d\n\n", a, b, res);

		// res = bc.hap(a);

	}

	static void use_object(Object ob) {

		// down-casting(강제형변환 / 사용영역을 확장)
		System.out.println("--다운 캐스팅 사용--");
		int n = 5, res;
		res = ((AdvanceCalc) ob).hap(n);
		System.out.printf("%d까지의 합 = %d\n\n", n, res);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 10, y = 3, res;

		AdvanceCalc ac = new AdvanceCalc();
		// use_basecalc 호출
		use_basecalc(ac);
		// use_object 호출
		use_object(ac);

		System.out.println("--메인 코드 사용--");
		res = ac.plus(x, y);
		System.out.printf("%d + %d = %d\n", x, y, res);

		res = ac.hap(x);
		System.out.printf("%d까지의 합 = %d\n", x, res);

		// down-casting할 때 주의사항
		BaseCalc bc1 = new BaseCalc();
		
		//객체 내에 AdvanceCalc기능은 없다.
		AdvanceCalc ac1 = (AdvanceCalc) bc1;
		//AdvanceCalc가 만들어지지 않은 상태에서 강제 형변환하려는 거 > 도둑놈 심보!

	}

}
