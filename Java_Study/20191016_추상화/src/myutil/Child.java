package myutil;

public class Child extends Parent {

	public void sub() {
		System.out.println("--Child.sub() call--");
	}

	public void sub2() {
		System.out.println("--Child.sub2() call--");
	}

	// Annotation : �ּ�
	@Override
	public void hi() {
		super.hi(); // �θ��� hi ��
		System.out.println("---���� �氡---");
	}

}

