package myutil;

public class MyDate {

	//��ü�����������鿡�� �������(field)�� 
	//��κ� ��������(private) �ʴ´�
	
	//Member field(property)
	private		int year;
	protected 	int month;
	private		int day;
				int week_day;
	//Member Method			
	//day �� ������ �� �ִ� �޼ҵ�
	//setter method:�����͸� �����ϴ� �޼ҵ�			
    // ���� : set�ʵ��(�μ�)
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
	// ���� : get�ʵ��()
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

	//����� ���: 2019-08-10
	public void display() {
		System.out.printf("%d-%02d-%02d\n",
				          year,month,day);
	}
	
				
	 			
				
}
