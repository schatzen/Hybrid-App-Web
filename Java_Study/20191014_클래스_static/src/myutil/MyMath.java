package myutil;

public class MyMath {

	// 외부에서 객체 생성 못하게!
	// public으로 변경하면 객체 생성 o
	
	private MyMath() {

	}

	public static int plus(int a, int b) {
		return a + b;
	}

	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int hap(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + i;
		}
		return sum;
	}

}