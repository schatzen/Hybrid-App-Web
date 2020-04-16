class 문제11 {
	public static void main(String[] args) {

		double pi = 0; // for 누적식인 걸 기억해라
		int op = 1;

		for (int i = 1; i <= 100000; i = (i + 2)) {
			pi = pi + (4.0 / i) * op;
			op = op * (-1);
		}

		System.out.println(pi);
	}
}
