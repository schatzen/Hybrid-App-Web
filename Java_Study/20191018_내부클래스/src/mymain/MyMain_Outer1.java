package mymain;



import myutil.Outer1;

public class MyMain_Outer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Outer1 out1 = new Outer1(); // 얘를 먼저 만들어야 Outer1안의 내부클래스 사용할 수 O

		// 생성된 외부객체를 통해서 내부객체 생성
		// Outer1.Inner1 inner1 = new Outer1.Inner1(); 이렇게 쓰는 경우는 X
		Outer1.Inner1 inner1 = out1.new Inner1();

		Outer1.Inner1 inner1_1 = new Outer1().new Inner1(); // 이렇게 만드는 경우는 가능!

		inner1.display();

		// Inner2 내부 클래스는 static이라서 이 메소드 가능
		Outer1.Inner2 inner2 = new Outer1.Inner2();
		inner2.display();

		// 실무에서는 이렇게 안 씀. 왜냐하면 내부 클래스는 그 클래스 안에서 사용하려고 생성하는거기 때문.
		// 굳이 내부클래스를 외부에서 안꺼내도 된다 ㅋ
		
		
		//로컬 내부 클래스 테스트 
		//얘는 이름이 있음
		new Outer1().method();
		
		//익명 내부 클래스 테스트
		//얘는 이름이 없음
		new Outer1().method2();

	}

}
