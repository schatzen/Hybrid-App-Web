package mymain;

class A {

}

class B extends A {

}

class C extends B {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Object > A > B > C 상속";
	}

}

class D {

}

public class MyMain_instanceOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object c = new C(); // c가 Object만 쓸 수 있어도 A,B를 참조하는 것엔 변함X

		// Object 객체를 포함하고 있나?
		System.out.println(c instanceof Object);
		System.out.println(c instanceof A);
		System.out.println(c instanceof B);
		System.out.println(c instanceof C);
		// System.out.println(c instanceof D);

		System.out.println(c);

	}

}
