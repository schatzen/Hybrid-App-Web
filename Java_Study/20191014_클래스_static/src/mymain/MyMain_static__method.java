package mymain;

import myutil.MyMath;

public class MyMain_static__method {

	public static void main(String[] args) {

		// ��ü�� ������ ������ �޼ҵ带 ����ϱ� ���ؼ�
		// static method�� ��ü�������� Ŭ������. �޼ҵ��()�� ����Ѵ�.
		// MyMath �뵵: ���񽺱��(Method)�� ó���ϴ� ��ü

		int a = 10, b = 5, res;

		res = MyMath.plus(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);

		res = MyMath.hap(a);
		System.out.printf("%d��(��) %d������ ���Դϴ�.\n", res, a);

		// MyMath mm = new MyMath(); > private���� public���� �������� �� ��밡��

		res = MyMath.max(a, b);
		System.out.printf("%d��(��) %d �� ū ���� %d\n", a, b, res);

		// ���� API max���
		// Math m = new Math();�� ��ü���� �� ����.
		// Math���� ��� ��ɵ��� static �޼ҵ� % private Ŭ�����̱� ����
		// Math�� �����͸� ����/�����Ϸ��� Ŭ������ �ƴ϶� ������ ���� ���� �뵵�� Ŭ�����̴�.

		res = Math.max(a, b);
		System.out.printf("%d��(��) %d �� ū ���� %d\n", a, b, res);

	}

}