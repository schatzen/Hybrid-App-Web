package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_�ζ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int[] user_no = new int[6];
		String yn = "y";

		Lotto lotto = new Lotto();
		
		lotto.make_win_no();
		

		while (true) {
			System.out.print("���� 5���� �Է��ϼ��� : ");

			for (int i = 0; i < user_no.length; i++)
				user_no[i] = scan.nextInt();

			// �Է¹�ȣ ����
			lotto.setUser_no(user_no);

			// ��÷��� ���
			lotto.display();

			// �� �ҷ�?
			System.out.print("�� �ҷ� ? (y/n) : ");
			yn = scan.next();

			if (!yn.equalsIgnoreCase("y"))
				break;

		}

		
		/*
		 * ser_no[0] = scan.nextInt(); ser_no[1] = scan.nextInt(); ser_no[2] =
		 * scan.nextInt(); ser_no[3] = scan.nextInt(); ser_no[4] = scan.nextInt();
		 * ser_no[5] = scan.nextInt(); ser_no[i] = scan.nextInt();
		 */
		System.out.println("----END----");
	}

}
