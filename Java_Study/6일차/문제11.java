class ����11 {
	public static void main(String[] args) {

		double pi = 0; // for �������� �� ����ض�
		int op = 1;

		for (int i = 1; i <= 100000; i = (i + 2)) {
			pi = pi + (4.0 / i) * op;
			op = op * (-1);
		}

		System.out.println(pi);
	}
}
