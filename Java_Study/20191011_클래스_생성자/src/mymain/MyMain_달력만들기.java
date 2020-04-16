package mymain;

import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_달력만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int year, month;
		String yn = "y";

		MyCalendar mc = new MyCalendar();

		while (true) {

			System.out.print("년/ 월 (Ex. 2019 10) : ");
			year = scan.nextInt();
			month = scan.nextInt();

			// year, month 설정
			mc.setDate(year, month);

			// 달력출력
			mc.display();

			// 또 할래?
			System.out.println("또 할래?");
			yn = scan.next();

			// 입력 받은 값이 y가 아니면 끝내라(while탈출해라)
			if (yn.equalsIgnoreCase("y") == false)
				break;

		}

	}

}
