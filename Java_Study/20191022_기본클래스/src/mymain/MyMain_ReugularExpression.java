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
			System.out.println("--��ȭ��ȣ ���� ��ġ--");
		else
			System.out.println("--��ȭ��ȣ ����ġ--");

		// ^ : ���۹���
		// $ : ������ ����

		String regEx1 = "^[a-zA-Z][0-9]{1,3}$";
		String str = "a111";
		if (Pattern.matches(regEx1, str)) {
			System.out.println("--���Խ� ��ġ�ϴ� ����--");
		} else {
			System.out.println("--����ġ--");
		}
	}

}
