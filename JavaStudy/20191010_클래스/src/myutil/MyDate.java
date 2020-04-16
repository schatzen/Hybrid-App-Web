package myutil;

public class MyDate {

	//객체지향적인측면에서 멤버변수(field)는 
	//대부분 공개하지(private) 않는다
	
	//Member field(property)
	private		int year;
	protected 	int month;
	private		int day;
				int week_day;
	//Member Method			
	//day 를 수정할 수 있는 메소드
	//setter method:데이터를 수정하는 메소드			
    // 명명법 : set필드명(인수)
	public void setDay(int d) {
		day = d;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	//getter method
	// 명명법 : get필드명()
	public  int getYear() {
		return year;
	}
	
	public int getMonth() {
		
		return month;
	}
	
	public int getDay() {
		
		return day;
	}
	
	
	// int week_day;
	
	public int getWeek_day() {
		return week_day;
	}

	public void setWeek_day(int week_day) {
		this.week_day = week_day;
	}

	//년월일 출력: 2019-08-10
	public void display() {
		System.out.printf("%d-%02d-%02d\n",
				          year,month,day);
	}
	
				
	 			
				
}
