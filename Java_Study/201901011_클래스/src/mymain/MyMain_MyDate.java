package mymain;


import myutil.MyDate;

public class MyMain_MyDate {

	public static void main(String[] args) {

		MyDate in = new MyDate();
		// ��ü��.���
		//in.year = 2019;
		in.setYear(2019);

		// The field MyDate.month is not visible
		// in.month = 10; > protected
		in.setMonth(10);
		// in.day = 10; > private
		in.setDay(10);
		// in.weekday = 5; > default
		in.setWeek_day("��");
		
		in.display();
		
		
		//int month = in.month;
		int year = in.getYear();
		int month = in.getMonth();
		int day = in.getDay();
		String weekday = in.getWeek_day();
		
		
		
		System.out.println("��in���κ��� ���� ����");
		System.out.printf("%d�� %d�� %d�� %s���� \n",year,month,day,weekday);
		

	}

}
