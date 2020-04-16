class 문제3 {
	public static void main(String[] args) throws Exception {
		System.out.print("문자 1개를 입력하세요 >> ");
		int ch = System.in.read();

		if (ch >= 65 && ch <= 90) {
			System.out.printf("문자 %c는(은) 대문자입니다.\n", ch);
		} else if (ch >= 97 && ch <= 122) {
			System.out.printf("문자 %c는(은) 소문자입니다.\n", ch);
		} else if (ch >= 48 && ch <= 57) {
			System.out.printf("문자 %c는(은) 숫자입니다.\n", ch);
		} else {
			System.out.printf("문자 %c는(은) 특수문자입니다.\n", ch);
		}

		// 대문자냐?
		// 소문자냐?
		// 숫자냐?
		// 특수문자냐?
	}
}
