package mymain;

public class mymain_String�� {

	public static void main(String[] args) {

		// ������ ������� ( ��ü ���� )
		String s1 = "Twinkle";
		String s2 = "Twinkle";

		// ����� �������
		String s3 = new String("Little Star");
		String s4 = new String("Little Star");

		System.out.println("Twinkle ��");
		if (s1 == s2)
			System.out.println("---����---");
		else
			System.out.println("---Ʋ����---");

		System.out.println("Little Star ��");
		if (s3 == s4)
			System.out.println("---����---");
		else
			System.out.println("---Ʋ����---");

		System.out.println();

		// ----------------------------------------------

		System.out.println("Twinkle �� (equals)");
		if (s1.equals(s2))
			System.out.println("---����---");
		else
			System.out.println("---Ʋ����---");

		System.out.println("Little Star �� (equals)");
		if (s3.equals(s4))
			System.out.println("---����---");
		else
			System.out.println("---Ʋ����---");

	}

}
