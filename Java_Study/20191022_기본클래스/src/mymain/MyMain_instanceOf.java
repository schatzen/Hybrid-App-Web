package mymain;

class A {

}

class B extends A {

}

class C extends B {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Object > A > B > C ���";
	}

}

class D {

}

public class MyMain_instanceOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object c = new C(); // c�� Object�� �� �� �־ A,B�� �����ϴ� �Ϳ� ����X

		// Object ��ü�� �����ϰ� �ֳ�?
		System.out.println(c instanceof Object);
		System.out.println(c instanceof A);
		System.out.println(c instanceof B);
		System.out.println(c instanceof C);
		// System.out.println(c instanceof D);

		System.out.println(c);

	}

}
