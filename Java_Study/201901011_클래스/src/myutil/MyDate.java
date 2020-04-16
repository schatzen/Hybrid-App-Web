package myutil;

public class MyDate {

	// 객체지향적인 측면에서 멤버변수(field)는 대부분 공개하지 않습니다.
	// 대부분 private을 씀

	// 객체지향 이밪엥서는 변수를 중요한 것으로 간주!
	// Member field(=property) (클래스 안에 있는 변수)
	private int year; // 모두 공개 가능
	protected int month; // 상속 자식 & 같은 package 만 가능
	private int day;

	String week_day; // 같은 방에 가능

	// Member Method (클래스 안에 있는 메소드)
	// day를 수정할 수 있는 메소드
	// setter method : 데이터를 수정하는 메소드
	// 명명법: set필드명(인수) <메소드는 소문자로 시작>
	// setDay(o) set_day(x)

	public void setYear(int y) {
		year = y;
	}

	public void setMonth(int m) {
		month = m;
	}

	public void setDay(int d) {
		day = d;
	}

	public void setWeek_day(String week_day) {
		this.week_day = week_day;
	}

	// getter 메소드
	// 명명법:get필드명

	public String getWeek_day() {
		return week_day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	// 년월일 출력 " 2019-10-10
	public void display() {
		System.out.printf("%d-%02d-%02d\n", year, month, day);
	}

}
