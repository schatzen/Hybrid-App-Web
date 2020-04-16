package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {

		Save save1 = new Save("일깅동", 100000);
		Save save2 = new Save("이깅동", 200000);
		Save save3 = new Save("삼깅동", 300000);

		// 이율 설정
		Save.rate = 0.1; // 클래스멸. 변수명 = 값(static 변수 표현)

		System.out.println("---이율:0.1---");
		save1.display();
		save2.display();
		save3.display();

		// 이율 변경
		save1.rate = 0.2; // 만들어진 객체를 통해서도 표현 save2.rate save3.rate 상관x
							// 하지만 이클립스에서는 Save(클래스명).rate로 하는 걸 권장
							// 경고: statoc way로 표현하지 않아서

		System.out.println("---이율:0.2---");
		save1.display();
		save2.display();
		save3.display();
	}

}
