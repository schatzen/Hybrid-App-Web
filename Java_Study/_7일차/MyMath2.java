class MyMath2 {

	// 절대값 구하기
	public int abs(int n) {
		int t;

		// if(a>0) {
		// t = a;
		// } else {
		// t = -a;
		// }

		t = (n > 0) ? n : -n;
		return t;
	}

	// 실수 절대값 구하기
	public double abs(double d) {
		double t;

		t = (d > 0) ? d : -d;
		return t;

	}

	// 두 수 중 작은 수
	public int min(int a, int b) {
		int t;

		t = (a > b) ? a : b;
		return t;
	}

	// 세 수 중 작은 수
	public int min(int a, int b, int c) {
		int min_val;
		min_val = (a > b) ? a : b;
		min_val = (c > min_val) ? c : min_val;

		
		return min_val;
	}

	// 짝수의 합
	public int hap_even(int n) {
		int t = 0;

		for (int i = 0; i <= n; i += 2) {
			t += i;
		}

		return t;
	}

	public int hap_odd(int n) {

		int t = 0;
		for (int i = 1; i <= n; i += 2) {
			t += i;
		}

		return t;
	}

	// n까지의 수 중에서 m의 배수의 합
	// hap(10,3) >> 3, 6, 8 = 18
	public int hap(int n, int m) {
		int t = 0;

		for (int i = 0; i <= n; i += m) {
			t += i;
		}
		return t;

	}

	// 팩토리알 구하기
	public double factorial(int n) {
		double t = 1;

		for (int i = n; i >= 1; i--) {
			t = t * i;
		}

		return t;
	}

	// n까지의 수 중 소수를 출력하세요
	public void sosu(int n) {

		for (int i = 2; i <= n; i++) {
			boolean bSosu = true;
			// 소수체크 로직
			for (int k = 2; k < i; k++) {

				// 나눠지면

				if (i % k == 0) {
					bSosu = false;
					break;
				}
			}

			if (bSosu)

			{ // 소수면
				System.out.println(i + " ");
			}
		}

		System.out.println(); // 줄 바꾸기
	}
}
