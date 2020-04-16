package myutil;

import java.util.Calendar;

public class MyCalendar {

	int year, month;
	int[][] cal_array = new int[6][7];
	

	//String[] week_day = new String[6];

	// 매월 마지막날을 저장할 때 배열
	// 0 1 2 3 4 5 6 7 8 9 10 11
	int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String [] week_day = {"일","월","화","수","목","금","토"};

	Calendar cal = Calendar.getInstance();

	// 년월을 입력받는 메소드
	// 인스턴스 메소드 < 객체가 생성되어야 생성되는 메소드
	public void setDate(int year, int month) {
		this.year = year;
		this.month = month;

		// 달력만들기
		make_calendar();
	}

	// 윤년여부?
	public boolean isYoon() {

		boolean result = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
		return result;
	}

	private void make_calendar() {
		cal_array = new int[6][7];

		int week = 0;

		int yoil = 0;

		// ??윤년여부
		if (this.isYoon())
			month_array[1] = 29;
		else
			month_array[1] = 28;

		// 요일구하기

		Calendar n = Calendar.getInstance();

		n.set(year, month - 1, 1);

		// 요일구하기
		yoil = n.get(Calendar.DAY_OF_WEEK) - 1;

		// System.out.println("요일:" + yoil_f);
		// 이전달 달력채우기
		if (yoil != 0) {
			int prev_yoil = yoil - 1;
			int prev_last_day;

			if (month_array[month - 1] == month_array[0])
				prev_last_day = month_array[11];
			else
				prev_last_day = month_array[month - 2];

			for (int i = prev_yoil; i >= 0; i--) {
				cal_array[week][i] = prev_last_day;
				prev_last_day--;

			}
		}

		// 이번달 달력채우기

		for (int i = 1; i <= month_array[month - 1]; i++) {
			cal_array[week][yoil] = i;
			yoil++;

			if (yoil > 6) {
				yoil = 0;
				week++;

			}
		}

		for (int i = 1; i < 20; i++) {

			cal_array[week][yoil] = i;
			yoil++;

			if (yoil > 6) {
				yoil = 0;
				week++;
				
				  if (week >= 6) 
					  break;
				 
			}
		}

	}

	// 다음달 달력 채우기
	/*
	 * for (int i = 1; i <= yoil_f; i++) {
	 * 
	 * cal_array_f[week_f][yoil_f] = i; yoil_f++;
	 * 
	 * if (yoil_f > 6) { yoil_f = 0; week_f++; }
	 * 
	 * }
	 */

	public void display() {
		// 요일출력
		for (int i = 0; i < 7; i++) {
			System.out.printf("%6s",week_day[i]);
		}
		System.out.println();

		// 이전달

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 7; k++) {
				System.out.printf("%4d", cal_array[i][k]);
			}
			System.out.println();

		}

	}
}
