package myutil;

import java.util.Calendar;

public class MyCalendar {

	int year, month;
	int[][] cal_array = new int[6][7];
	

	//String[] week_day = new String[6];

	// �ſ� ���������� ������ �� �迭
	// 0 1 2 3 4 5 6 7 8 9 10 11
	int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String [] week_day = {"��","��","ȭ","��","��","��","��"};

	Calendar cal = Calendar.getInstance();

	// ����� �Է¹޴� �޼ҵ�
	// �ν��Ͻ� �޼ҵ� < ��ü�� �����Ǿ�� �����Ǵ� �޼ҵ�
	public void setDate(int year, int month) {
		this.year = year;
		this.month = month;

		// �޷¸����
		make_calendar();
	}

	// ���⿩��?
	public boolean isYoon() {

		boolean result = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
		return result;
	}

	private void make_calendar() {
		cal_array = new int[6][7];

		int week = 0;

		int yoil = 0;

		// ??���⿩��
		if (this.isYoon())
			month_array[1] = 29;
		else
			month_array[1] = 28;

		// ���ϱ��ϱ�

		Calendar n = Calendar.getInstance();

		n.set(year, month - 1, 1);

		// ���ϱ��ϱ�
		yoil = n.get(Calendar.DAY_OF_WEEK) - 1;

		// System.out.println("����:" + yoil_f);
		// ������ �޷�ä���
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

		// �̹��� �޷�ä���

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

	// ������ �޷� ä���
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
		// �������
		for (int i = 0; i < 7; i++) {
			System.out.printf("%6s",week_day[i]);
		}
		System.out.println();

		// ������

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 7; k++) {
				System.out.printf("%4d", cal_array[i][k]);
			}
			System.out.println();

		}

	}
}
