package myutil;

public class MyDate2 {

	private int year,month,day;
	
	public MyDate2() {
		// TODO Auto-generated constructor stub
	}

	public MyDate2(int year, int month, int day) {
		//super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public MyDate2(int year) {
		super();
		this.year = year;
	}

	public MyDate2(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	
	
	
}
