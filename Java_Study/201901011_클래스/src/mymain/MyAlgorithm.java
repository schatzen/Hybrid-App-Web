package mymain;

import java.util.Scanner;

import myutil.Mabangjin;

public class MyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Mabangjin ma = new Mabangjin();

		int chasu;
		String yn = "y";

		while (true) {

			System.out.printf("차수 : ");
			chasu = scan.nextInt();

			if (chasu % 2 == 0) {
				System.out.println("홀수만 입렭하세요");
			}

			// 차수전달
			ma.setChasu(chasu);

			// 마방진 출력
			ma.display();

			// 또 할래?
			System.out.printf("그만할래? (y/n)");
			yn = scan.next();

			// if(yn.equals("y")||yn.equals("Y")) break;
			if (yn.equalsIgnoreCase("y"))
				break; // :대소문자 가리지 않는 API

		}

		System.out.println("ㅡEndㅡ"); // break가 없으면 도달할 수 없는 코드라고 에러 뜸.

	}
}
