package myutil;


abstract class MyAbs{
   public abstract void display();	
}

class MyTest{
	public void sub() {}
}

interface MyInterface{
	void hi();
}


public class Outer1 {
	
	//인터페이스을 이용한 익명 내부클래스
	/*
	class MyInterfaceImpl implements MyInterface
	{
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
	
	
	
	//멤버로써의 익명내부클래스(일반클래스)
	MyTest test = new MyTest() {
		public void sub() {
			
		}
	};
	
	
	
	public void method2() {
		//4.익명(Anonymous)내부클래스
		//MyAbs ob = new MyAbs();
		/*
		class MyAbsInner extends MyAbs{
			@Override
			public void display() {
				// TODO Auto-generated method stub
	            System.out.println("--MyAbsInner.display()--");			
			}
		}
		MyAbs abs = new MyAbsInner();
		abs.display();
		*/
		
		//Anoymous inner class(
		MyAbs abs = new MyAbs() {
			
			@Override
			public void display() {
				// TODO Auto-generated method stub
				System.out.println("--Anoymous.display()--");	
			}
		};
		
		abs.display();
		
		
	}
	
	
	
	
	
	static int s;
	private int n;
	//1.멤버로써의 내부(중첩)클래스
	//인스턴스 내부클래스
	public class Inner1{
		public void display() {
			n = 10;
			System.out.println("--Outer1.Inner1.display()--");
		}
	}
	
	//2.정적(static) 내부클래스
	public static class Inner2{
		public void display() {
			//n = 20; instance변수 사용 못함
			s = 10;  // static멤버만 사용가능 
			System.out.println("--Outer1.Inner2.display()--");
		}
	}
	
	
	public void method() {
		//3.local내부 클래스
		class Inner3{
			public void display() {
				System.out.println("method내의 Inner3.display()--");
				System.out.println("Outer1's n의 값:" + n);
			}
		}
		Inner3 inner3 = new Inner3();
		inner3.display();
	}
	
}
