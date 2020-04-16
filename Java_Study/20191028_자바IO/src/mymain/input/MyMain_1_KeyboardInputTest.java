package mymain.input;

import java.io.IOException;
import java.io.InputStream;

public class MyMain_1_KeyboardInputTest {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 키보드 장치의 입력스트림 얻기
		InputStream is = System.in;
		System.out.println("종료 : ctrl + z");

		while (true) {
			int ch = is.read();
			// Ctrl + Z 누르면 -1 반환
			if (ch == -1) {

				System.out.println("종료합니다");
				break;
			}
			System.out.printf("%c", ch);
		}

	}

}
