package mymain;

import myutil.MyDate;

public class MyMain_MyDate {

	public static void main(String[] args) {
		
		MyDate in = new MyDate();
		//��ü��.���
		//in.year = 2019;
		in.setYear(2019);
				
		//The field MyDate.month is not visible
		//in.month = 10; //protected
		in.setMonth(10);
		//in.day = 10; //private
		in.setDay(10);
		//in.week_day = 5;
		
		in.display();
		
		//int year = in.year;
		//int month = in.month;
		int year  = in.getYear();
		int month = in.getMonth();
		int day   = in.getDay();
		
		System.out.println("--in���κ��� ���°�--");
		System.out.printf("%d�� %d�� %d��\n",year,month,day);
		
		
		
		
		
		
		
		
		
		
		
	}
}
