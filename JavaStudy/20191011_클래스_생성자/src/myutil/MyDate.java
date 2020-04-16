package myutil;

import java.util.Calendar;

/*
	 ������(Constructor) 
	 1.��ü������ �ʱ�ȭ ����
	 2.����)
	   1)Ŭ������(){}
	   2)��ȯ�� ���� 
	 3.��ü������ �ڵ�ȣ�� �ȴ�
	 4.���������ϴ�(JVM�� �⺻�����ڸ� ���������� �����ؼ� ó��)
	 5.�ߺ����ǰ���(Method Overload)
	   �ߺ����ǵ� ������ �����ÿ��� ������ �⺻������ �����ض�..
 
  
 */

public class MyDate {

	private int year,month,day;
	
	//�⺻������(default constructor)
	public  MyDate() {
		System.out.println("--MyDate()--");
		//year=month=day=1;
		//���� �ý��� ��¥���ϱ�(����Ͻú��ʿ�������...)
		Calendar c = Calendar.getInstance();
		
		year = c.get(Calendar.YEAR);
		month= c.get(Calendar.MONTH)+1;
		day  = c.get(Calendar.DAY_OF_MONTH);
	}
	
		
	//Overload�� ������
	public MyDate(int y) {
		//�ڽ��� �����ڸ� ǥ���Ҷ�
		this(); // MyDate()
		
		System.out.println("--MyDate(y)--");
		this.year = y;
		
	}
	
	//Overload�� ������
	public MyDate(int y,int m) {
		System.out.println("--MyDate(y,m)--");
		year = y;
		month= m;
		day=1;
	}
	
	
	//Overload�� ������
	public MyDate(int y,int m,int d) {
		
		System.out.println("--MyDate(y,m,d)--");
		
		year 	= y;
		month 	= m;
		day 	= d;
	}
	
	
	
	//�Ϲݸ޼ҵ�
	public void display() {
		System.out.printf("%04d-%02d-%02d\n",year,month,day);
	}
	
}
