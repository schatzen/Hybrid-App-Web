package mymain;

public class MyMain_final {
	
	/*
	 * final 
	 * 1.변수 : final 자료형 변수명 = 갑;
	 * 				(상수선언)
	 * 2.메소드 : final 자료형 메소드명()
	 * 			(더이상 재정의 하지 말아라)
	 * 
	 * 3.클래스 : final class 클래스명
	 * 			(상속하지 말아라)
	 */
	

	final static String PROGRAM_NAME = "final 연습";

	public static void main(String[] args) {

		System.out.println(MyMain_final.PROGRAM_NAME);
		
		//MyMain_final.PROGRAM_NAME = "연습 final"; 이런식으로 변경 수정 X
		// can not be assigned : 대입X

	}

}
