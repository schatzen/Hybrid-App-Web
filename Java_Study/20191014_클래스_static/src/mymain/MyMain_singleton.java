package mymain;

import myutil.MySingleton;

public class MyMain_singleton {

	static void 합구해줘(int i) {
		// MySingleton ms = new MySingleton();

		MySingleton ms = MySingleton.getInstance();

		int res = ms.hap(i);

		System.out.printf("%d까지의 합: %d\n", i, res);
	}

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			MyMain_singleton.합구해줘(i);

		}
	}
}
