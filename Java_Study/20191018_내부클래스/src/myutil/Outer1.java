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

	// �������̽��� �̿��� ����Ŭ����
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

	// ����μ��� �͸� ���� Ŭ���� (�Ϲ�Ŭ����)
	MyTest test = new MyTest() {
		public void sub() {
		};

	};

	public void method2() {

		// 4. �͸�(Anonymous) ���� Ŭ����
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
		// ��ü�� ���� ���ÿ� + �������̵�. ���� �ڵ��� ���� �Ӽ��̴�.
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

	// ������ ������ bin������ ����.
	// ����Ŭ������ ����Ǵµ�, Outer1&Inner1.java �̷������� ����Ǿ�����! ����

	// 1. ����ν��� ����(��ø)Ŭ����
	// �ν��Ͻ� ���� Ŭ���� ( Outer1 ��ü�� ���� ������ ��������� Ŭ�����ϱ�.)
	public class Inner1 {
		public void display() {
			n = 10;
			System.out.println("--Outer1.Inner1.display()--");
		}

	}

	// 2. ����(static) ���� Ŭ����
	public static class Inner2 {
		public void display() {
			// n=20; instance���� ��� ����. //���� ��������� ������ �ٸ��Ƿ�.
			s = 20; // static ����� ��밡���ϴ�.
			System.out.println("--Outer1.Inner2.display()--");
		}
	}

	public void method() {
		// 3. local ���� Ŭ����
		class Inner3 {
			public void display() {
				System.out.println("method���� Inner3.display()--");
				System.out.println("Outer1's n�� �� : " + n);
			}
		}

		Inner3 inner3 = new Inner3();
		inner3.display();

	}
}
