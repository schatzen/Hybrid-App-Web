package mymain;

import myutil.����л�;
import myutil.���л�;
import myutil.�ʵ��л�;
import myutil.�л�;

public class MyMain_�л� {

	static void ������(�л�[] s_array) {

		// ������(Polymorphism)
		// : ������ ��ɿ� ���Ͽ� ��ü���� �ڽŸ��� ����
		for (int i = 0; i < s_array.length; i++) {
			�л� student = s_array[i];
			student.�����Ѵ�();
		}

	}

	static void ������2(�л�[] s_array) {

		// ������(Polymorphism)
		// : ������ ��ɿ� ���Ͽ� ��ü���� �ڽŸ��� ����
		for (�л� student : s_array) {

			student.�����Ѵ�();
		}

	}

	public static void main(String[] args) {

		�л�[] s_array = { new �ʵ��л�(), new ���л�(), new ����л�() };

		������(s_array);

		System.out.println("--����loop(����)--");
		������2(s_array);

		int[] nr = { 1, 2, 3 };

		System.out.println("--÷���̿�--");
		for (int i = 0; i < nr.length; i++) {
			int n = nr[i];
			System.out.println(n);
		}

		System.out.println("--���� loop--");
		for (int n : nr) {
			System.out.println(n);
		}

	}

}
