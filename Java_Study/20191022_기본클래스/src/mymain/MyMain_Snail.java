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
			System.out.println("행 열 개수 : ");
			row_count = scan.nextInt();
			col_count = scan.nextInt();

			// 달팽이 객체에게 행/열갯수 넘기기
			snail.setData(row_count, col_count);

			// 달팽이 생성 결과 출력
			snail.display();
			

			System.out.println("또 할래? (y/n)");
			yn = scan.next();
			if (!yn.equalsIgnoreCase("y"))
				break;

		}
		System.out.println("--End--");
	}

}
