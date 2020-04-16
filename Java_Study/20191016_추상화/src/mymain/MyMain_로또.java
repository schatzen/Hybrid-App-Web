package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_로또 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int[] user_no = new int[6];
		String yn = "y";

		Lotto lotto = new Lotto();
		
		lotto.make_win_no();
		

		while (true) {
			System.out.print("숫자 5개를 입력하세요 : ");

			for (int i = 0; i < user_no.length; i++)
				user_no[i] = scan.nextInt();

			// 입력번호 전달
			lotto.setUser_no(user_no);

			// 추첨결과 출력
			lotto.display();

			// 또 할래?
			System.out.print("또 할래 ? (y/n) : ");
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
