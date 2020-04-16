package mymain;

public class MyMain_배열활용2 {

	// Elipsis : 배열로 인식 & ... < 인자갯수 정해지지 않은 경우
	static void display(int... nr) {
		// int [] nr = {10};
		// int [] nr = {10, 20};
		// int [] nr = {10,20,30};
		System.out.print("[");
		for (int i = 0; i < nr.length; i++) {
			System.out.printf("%d", nr[i]);
		}
		System.out.println("]");

	}

	// n개의 수 중에서 가장 큰 수 구하기
	static int max(int... nr) {
		int max_val = Integer.MIN_VALUE;
		// int [] nr = {10, 50, 15};

		for (int i = 0; i < nr.length; i++) {
			max_val = (nr[i] > max_val) ? nr[i] : max_val;
		}
		return max_val;

	}

	public static void main(String[] args) {
		display(10);
		display(10, 20);
		display(10, 20, 30);

		int a = 10, b = 50, c = 15, res;
		res = max(13, 14, 1, 563, 4, 53, 245, 2, 45, 3, 3324, 52);

		// System.out.printf("%d,%d,%d 중 가장 큰 수는 %d\n",a,b,c,res);
		System.out.printf("가장 큰 수는 %d\n", res);

	}

}
