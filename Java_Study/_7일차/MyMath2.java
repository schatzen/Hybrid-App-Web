class MyMath2 {

	// ���밪 ���ϱ�
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

	// �Ǽ� ���밪 ���ϱ�
	public double abs(double d) {
		double t;

		t = (d > 0) ? d : -d;
		return t;

	}

	// �� �� �� ���� ��
	public int min(int a, int b) {
		int t;

		t = (a > b) ? a : b;
		return t;
	}

	// �� �� �� ���� ��
	public int min(int a, int b, int c) {
		int min_val;
		min_val = (a > b) ? a : b;
		min_val = (c > min_val) ? c : min_val;

		
		return min_val;
	}

	// ¦���� ��
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

	// n������ �� �߿��� m�� ����� ��
	// hap(10,3) >> 3, 6, 8 = 18
	public int hap(int n, int m) {
		int t = 0;

		for (int i = 0; i <= n; i += m) {
			t += i;
		}
		return t;

	}

	// ���丮�� ���ϱ�
	public double factorial(int n) {
		double t = 1;

		for (int i = n; i >= 1; i--) {
			t = t * i;
		}

		return t;
	}

	// n������ �� �� �Ҽ��� ����ϼ���
	public void sosu(int n) {

		for (int i = 2; i <= n; i++) {
			boolean bSosu = true;
			// �Ҽ�üũ ����
			for (int k = 2; k < i; k++) {

				// ��������

				if (i % k == 0) {
					bSosu = false;
					break;
				}
			}

			if (bSosu)

			{ // �Ҽ���
				System.out.println(i + " ");
			}
		}

		System.out.println(); // �� �ٲٱ�
	}
}
