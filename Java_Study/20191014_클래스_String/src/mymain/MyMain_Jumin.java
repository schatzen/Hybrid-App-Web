package mymain;

import java.util.Scanner;

import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String jumin_no;
		String yn = "y";

		Jumin jumin = new Jumin();

		while (true) {
			System.out.print("�ֹι�ȣ(xxxxxx-xxxxxx):");
			jumin_no = scan.next();

			// �ֹι�ȣ �ѱ��
			jumin.setJumin_no(jumin_no);

			// ������ ���
			int year = jumin.getYear();
			int age = jumin.getAge();
			String tti = jumin.getTti();
			String local = jumin.getLocal();
			String season = jumin.getSeason();
			String gender = jumin.getGender();
			String ganji = jumin.getGanji();
			Boolean isValid = jumin.isValid();

			System.out.printf("����⵵:%d��\n", year);
			System.out.printf("����:%d(��)\n", age);
			System.out.printf("��:%s(��)\n", tti);
			System.out.printf("����:%s\n", local);
			System.out.printf("����:%s\n", season);
			System.out.printf("����:%s\n", gender);
			System.out.printf("����:%s(��)\n", ganji);
			System.out.println(isValid);

			// �� �ҷ�?
			System.out.println("�� �ҷ�?(y/n) : ");
			yn = scan.next();

			// �Է°��� y�� �ƴϸ� ������
			if (!yn.equalsIgnoreCase("y"))
				break;

		}

		System.out.println("--END--");

	}

}