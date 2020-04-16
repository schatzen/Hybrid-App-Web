package mymain;

public class MyMain_static초기화 {

	// static 초기화
	static {
		System.out.println("0.무슨 소리, 내가 먼저 호출돼!");

		// 1. DB Driver Loading ...
		// 2. 프로그램에 필요한 자원(Resource)
		// Resource : 이미지 사운드... resource는 컴파일은 안하지만 메모리에 올려놓아야 사용가능한 파일들을 말함 (재사용가능한
		// 파일)

		/*
		 * 게임 같은거 만들 때 미리 이미지나 음향 초기화 시키고 싶을 때, 메인메소드 말고 static에 미리 준비할 수 o 음식 경연 시작하기
		 * 전에 미리 재료 손질을 해놓는 격! 메인 메소드에 올려 놓는 것은 경연시작하고 재료 손질하는 격!
		 */
	}

	public static void main(String[] args) { // 스태틱 메소드
		// TODO Auto-generated method stub

		System.out.println("1.내가 제일 먼저 호출돼");

	}

	static {
		System.out.println("0-1.무슨 소리, 내가 먼저 호출돼!");
	}

}
