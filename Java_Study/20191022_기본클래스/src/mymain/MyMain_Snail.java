package mymain;

import java.util.Scanner;

import myutil.Snail;

public class MyMain_Snail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Snail snail = new Snail();

		Scanner scan = new Scanner(System.in);
		int row_count, col_count;
		String yn = "y";

		while (true) {
			System.out.println("�� �� ���� : ");
			row_count = scan.nextInt();
			col_count = scan.nextInt();

			// ������ ��ü���� ��/������ �ѱ��
			snail.setData(row_count, col_count);

			// ������ ���� ��� ���
			snail.display();
			

			System.out.println("�� �ҷ�? (y/n)");
			yn = scan.next();
			if (!yn.equalsIgnoreCase("y"))
				break;

		}
		System.out.println("--End--");
	}

}
