package myutil;

import java.util.Calendar;

/*
������(Constructor)
1. ��ü ������ �ʱ�ȭ ����
2. ���� )
	1) Ŭ������() {}
	2) ��ȯ�� ����
3. ��ü������ �ڵ�ȣ�� �ȴ�
4. ���������ϴ� (JVM�� �⺻�����ڸ� ���������� �����ؼ� ó��)
5. �ߺ����� ���� (Method Overload)
      �ߺ����ǵ� ������ �����ÿ��� ������ �⺻������ �����ض�

*/

public class MyDate {

	int year, month, day;

	// �⺻ ������(default constructor)
	// public void MyDate() < �Ϲ� �޼ҵ��̸�, void�� ��ȯ���̴�
	public MyDate() {

		System.out.println("--MyDate()--");
		// year=month=day=1;

		// ���� �ý��� ��¥ ���ϱ� (����Ͽ��� �ú��� ���� ����)
		// new�� ���� x �̱� ���̶�
		Calendar c = Calendar.getInstance();

		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DAY_OF_MONTH); // = DATE(��)

	}

	// Overload�� ������ (1)
	public MyDate(int y, int m, int d) {
		System.out.println("--MyDate(y,m,d)--");
		year = y;
		month = m;
		day = d;

	}

	// Overload�� ������ (2)
	public MyDate(int y) {
		// �ڽ��� �����ڸ� ǥ���� ��
		// MyDate(); �̷��� �ڽ��� �����ڸ� ȣ�� �� ��
		this(1,1,1); // MyDate(); ȣ���ϴ� ��! year�� �����ϰ� month �� day �� �ڵ� �ʱ�ȭ��

		System.out.println("--MyDate(y)--");
		this.year = y;

	}

	// Overload�� ������ (3)
	public MyDate(int y, int m) {
		System.out.println("--MyDate(y,m)--");
		year = y;
		month = m;
		day = 5;
	}

	// �Ϲ� �޼ҵ�
	public void display() {
		System.out.printf("%04d-%02d-%02d\n", year, month, day);
		System.out.println();

	}

}
