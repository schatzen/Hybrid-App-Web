package mymain;

import myutil.MyMath;

public class MyMain_static__method {

	public static void main(String[] args) {

		// 객체를 생성한 이유는 메소드를 사용하기 위해서
		// static method는 객체생성없이 클래스명. 메소드명()을 사용한다.
		// MyMath 용도: 서비스기능(Method)만 처리하는 객체

		int a = 10, b = 5, res;

		res = MyMath.plus(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);

		res = MyMath.hap(a);
		System.out.printf("%d는(은) %d까지의 합입니다.\n", res, a);

		// MyMath mm = new MyMath(); > private에서 public으로 변경했을 때 사용가능

		res = MyMath.max(a, b);
		System.out.printf("%d와(과) %d 중 큰 수는 %d\n", a, b, res);

		// 기존 API max사용
		// Math m = new Math();로 객체만들 수 없다.
		// Math내의 모든 기능들은 static 메소드 % private 클래스이기 때문
		// Math는 데이터를 저장/관리하려는 클래스가 아니라 일종의 서비스 제공 용도의 클래스이다.

		res = Math.max(a, b);
		System.out.printf("%d와(과) %d 중 큰 수는 %d\n", a, b, res);

	}

}