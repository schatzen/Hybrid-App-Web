package mymain;

import myutil.MySingleton;

public class MyMain_singleton {

	static void �ձ�����(int i) {
		// MySingleton ms = new MySingleton();

		MySingleton ms = MySingleton.getInstance();

		int res = ms.hap(i);

		System.out.printf("%d������ ��: %d\n", i, res);
	}

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			MyMain_singleton.�ձ�����(i);

		}
	}
}
