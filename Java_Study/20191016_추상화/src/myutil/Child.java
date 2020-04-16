package myutil;

public class Child extends Parent {

	public void sub() {
		System.out.println("--Child.sub() call--");
	}

	public void sub2() {
		System.out.println("--Child.sub2() call--");
	}

	// Annotation : 주석
	@Override
	public void hi() {
		super.hi(); // 부모의 hi 콜
		System.out.println("---하이 방가---");
	}

}

