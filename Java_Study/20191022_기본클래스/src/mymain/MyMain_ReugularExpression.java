package mymain;

import java.util.regex.Pattern;

public class MyMain_ReugularExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String regEx = (02|010)-\\d{3,4}-\\d{4};
		String regEx = "(02|010)-[0-9]{3,4}-[0-9]{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regEx, data);

		if (result)
			System.out.println("--전화번호 형식 일치--");
		else
			System.out.println("--전화번호 불일치--");

		// ^ : 시작문자
		// $ : 끝나는 문자

		String regEx1 = "^[a-zA-Z][0-9]{1,3}$";
		String str = "a111";
		if (Pattern.matches(regEx1, str)) {
			System.out.println("--정규식 일치하는 숫자--");
		} else {
			System.out.println("--불일치--");
		}
	}

}
