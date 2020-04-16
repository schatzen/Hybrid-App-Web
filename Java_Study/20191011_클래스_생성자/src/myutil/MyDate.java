package myutil;

import java.util.Calendar;

/*
생성자(Constructor)
1. 객체 생성지 초기화 목적
2. 형식 )
	1) 클래스명() {}
	2) 반환형 없다
3. 객체생성시 자동호출 된다
4. 생략가능하다 (JVM이 기본생성자를 내부적으로 생성해서 처리)
5. 중복정의 가능 (Method Overload)
      중복정의된 생성자 생성시에는 무조건 기본생성자 정의해라

*/

public class MyDate {

	int year, month, day;

	// 기본 생성자(default constructor)
	// public void MyDate() < 일반 메소드이며, void는 반환형이다
	public MyDate() {

		System.out.println("--MyDate()--");
		// year=month=day=1;

		// 현재 시스템 날짜 구하기 (년월일요일 시분초 몇주 몇차)
		// new로 생성 x 싱글 톤이라서
		Calendar c = Calendar.getInstance();

		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		day = c.get(Calendar.DAY_OF_MONTH); // = DATE(일)

	}

	// Overload된 생성자 (1)
	public MyDate(int y, int m, int d) {
		System.out.println("--MyDate(y,m,d)--");
		year = y;
		month = m;
		day = d;

	}

	// Overload된 생성자 (2)
	public MyDate(int y) {
		// 자신의 생성자를 표현할 때
		// MyDate(); 이렇게 자신의 생성자를 호출 못 함
		this(1,1,1); // MyDate(); 호출하는 격! year를 제외하고 month 와 day 가 자동 초기화됨

		System.out.println("--MyDate(y)--");
		this.year = y;

	}

	// Overload된 생성자 (3)
	public MyDate(int y, int m) {
		System.out.println("--MyDate(y,m)--");
		year = y;
		month = m;
		day = 5;
	}

	// 일반 메소드
	public void display() {
		System.out.printf("%04d-%02d-%02d\n", year, month, day);
		System.out.println();

	}

}
