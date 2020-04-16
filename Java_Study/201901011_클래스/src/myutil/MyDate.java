package myutil;

public class MyDate {

	// ��ü�������� ���鿡�� �������(field)�� ��κ� �������� �ʽ��ϴ�.
	// ��κ� private�� ��

	// ��ü���� �̓S������ ������ �߿��� ������ ����!
	// Member field(=property) (Ŭ���� �ȿ� �ִ� ����)
	private int year; // ��� ���� ����
	protected int month; // ��� �ڽ� & ���� package �� ����
	private int day;

	String week_day; // ���� �濡 ����

	// Member Method (Ŭ���� �ȿ� �ִ� �޼ҵ�)
	// day�� ������ �� �ִ� �޼ҵ�
	// setter method : �����͸� �����ϴ� �޼ҵ�
	// ����: set�ʵ��(�μ�) <�޼ҵ�� �ҹ��ڷ� ����>
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

	// getter �޼ҵ�
	// ����:get�ʵ��

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

	// ����� ��� " 2019-10-10
	public void display() {
		System.out.printf("%d-%02d-%02d\n", year, month, day);
	}

}
