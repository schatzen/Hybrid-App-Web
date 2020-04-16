package myutil;

abstract class MyAbs {

	public abstract void display();

}

class MyTest {
	public void sub() {
	}

}

interface MyInterface {
	void hi();
}

public class Outer1 {

	// 인터페이스를 이용한 내부클래스
	/* class MyInterfaceImpl implements MyInterface {

		@Override
		public void hi() {
			// TODO Auto-generated method stub
			
		}
		
	}
*/

	MyInterface myinter = new MyInterface() {

		@Override
		public void hi() {
			// TODO Auto-generated method stub

		}
	};

	// 멤버로서의 익명 내부 클래스 (일반클래스)
	MyTest test = new MyTest() {
		public void sub() {
		};

	};

	public void method2() {

		// 4. 익명(Anonymous) 내부 클래스
		// MyAbs ab = new MyAbs();
		/*
		 * class MyAbsInner extends MyAbs {
		 * 
		 * @Override public void display() { // TODO Auto-generated method stub
		 * System.out.println("--MyAbsInner.display()--");
		 * 
		 * }
		 * 
		 * } MyAbs abs = new MyAbsInner(); abs.display();
		 */

		// Anonymous inner class
		// 객체를 만든 동시에 + 오버라이딩. 위의 코딩과 같은 속성이다.
		MyAbs abs = new MyAbs() {

			@Override
			public void display() {
				// TODO Auto-generated method stub
				System.out.println("--Anonymous.display()--");

			}
		};
		abs.display();
	}

	static int s;
	private int n;

	// 컴파일 내용은 bin폴더에 저장.
	// 내부클래스도 저장되는데, Outer1&Inner1.java 이런식으로 저장되어있음! ㅎㅎ

	// 1. 멤버로써의 내부(중첩)클래스
	// 인스턴스 내부 클래스 ( Outer1 객체가 먼저 만들어야 만들어지는 클래스니까.)
	public class Inner1 {
		public void display() {
			n = 10;
			System.out.println("--Outer1.Inner1.display()--");
		}

	}

	// 2. 정적(static) 내부 클래스
	public static class Inner2 {
		public void display() {
			// n=20; instance변수 사용 못함. //서로 만들어지는 시점이 다르므로.
			s = 20; // static 멤버만 사용가능하다.
			System.out.println("--Outer1.Inner2.display()--");
		}
	}

	public void method() {
		// 3. local 내부 클래스
		class Inner3 {
			public void display() {
				System.out.println("method내의 Inner3.display()--");
				System.out.println("Outer1's n의 값 : " + n);
			}
		}

		Inner3 inner3 = new Inner3();
		inner3.display();

	}
}
