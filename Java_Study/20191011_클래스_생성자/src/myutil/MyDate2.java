package myutil;

public class MyDate2 {

	// 기본 생성자 쉽게 만드는 법

	private int year, month, day;// member field = instance 변수

	public MyDate2() {

	}

	public MyDate2(int year, int month, int day) {
		// super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public MyDate2(int year) {
		// super()
		this.year = year;
	}

	public MyDate2(int year, int month) {
		// super();
		this.year = year;
		this.month = month;
	}

	// field (변수)에 대해서 데이터 수정하고 싶으면
	// getter and setter 호출

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
