package mymain;

import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_�޷¸���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int year, month;
		String yn = "y";

		MyCalendar mc = new MyCalendar();

		while (true) {

			System.out.print("��/ �� (Ex. 2019 10) : ");
			year = scan.nextInt();
			month = scan.nextInt();

			// year, month ����
			mc.setDate(year, month);

			// �޷����
			mc.display();

			// �� �ҷ�?
			System.out.println("�� �ҷ�?");
			yn = scan.next();

			// �Է� ���� ���� y�� �ƴϸ� ������(whileŻ���ض�)
			if (yn.equalsIgnoreCase("y") == false)
				break;

		}

	}

}
