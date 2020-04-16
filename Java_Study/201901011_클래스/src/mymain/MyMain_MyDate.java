package mymain;


import myutil.MyDate;

public class MyMain_MyDate {

	public static void main(String[] args) {

		MyDate in = new MyDate();
		// 객체명.멤버
		//in.year = 2019;
		in.setYear(2019);

		// The field MyDate.month is not visible
		// in.month = 10; > protected
		in.setMonth(10);
		// in.day = 10; > private
		in.setDay(10);
		// in.weekday = 5; > default
		in.setWeek_day("목");
		
		in.display();
		
		
		//int month = in.month;
		int year = in.getYear();
		int month = in.getMonth();
		int day = in.getDay();
		String weekday = in.getWeek_day();
		
		
		
		System.out.println("ㅡin으로부터 얻어온 값ㅡ");
		System.out.printf("%d년 %d월 %d일 %s용일 \n",year,month,day,weekday);
		

	}

}
