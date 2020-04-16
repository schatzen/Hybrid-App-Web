package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_KeyboardInputTest2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 키보드 장치의 입력스트림 얻기
		InputStream is = System.in;

		// byte stream -> char stream 으로 포장
		InputStreamReader isr = new InputStreamReader(is); // 한글이 안 깨지기 위해 is를 char로 포장해줌 // reader는 전송단위가 char이기 때문
		System.out.println("종료 : ctrl + z");

		while (true) {
			int ch = isr.read(); // InputStream이 아니라 Reader로 부터 읽어오기
			// Ctrl + Z 누르면 -1 반환
			if (ch == -1) {

				System.out.println("종료합니다");
				break;
			}
			System.out.printf("%c", ch);
		}

	}

}
