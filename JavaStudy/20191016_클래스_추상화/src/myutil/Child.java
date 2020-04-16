package myutil;

public class Child extends Parent{

	public void sub() {
		System.out.println("--Child.sub() call--");
	}
	
	public void sub2() {
		System.out.println("--Child.sub2() call--");
	}

	
	//Anotation: 프로그램 주석
	@Override
	public void hi() {
		// TODO Auto-generated method stub
		super.hi();//부모의 hi() call
		System.out.println("--하이 방가--");
	}
	
	
	
}
