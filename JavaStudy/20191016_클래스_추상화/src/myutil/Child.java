package myutil;

public class Child extends Parent{

	public void sub() {
		System.out.println("--Child.sub() call--");
	}
	
	public void sub2() {
		System.out.println("--Child.sub2() call--");
	}

	
	//Anotation: ���α׷� �ּ�
	@Override
	public void hi() {
		// TODO Auto-generated method stub
		super.hi();//�θ��� hi() call
		System.out.println("--���� �氡--");
	}
	
	
	
}
