package mymain;

import myutil.Save;

/*
   static 변수/메소드
   1.생성시점: 프로그램 시작시
   2.사용방법
       클래스명.변수명
       클래스명.메소드명
 */


public class MyMain_Save {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Save s1 = new Save("일길동", 1000000);
		Save s2 = new Save("이길동", 2000000);
		Save s3 = new Save("삼길동", 3000000);
		
		//이율 설정
		Save.rate = 0.1;// 클래스명.변수명=값(static변수표현)
		
		System.out.println("--이율:0.1--");
		s1.display();
		s2.display();
		s3.display();
		
		//이율 변경
		s1.rate = 0.2;//(경고:static way 표현하지 않아서...)
		System.out.println("--이율:0.2--");
		s1.display();
		s2.display();
		s3.display();
		
		
		
	}

}
