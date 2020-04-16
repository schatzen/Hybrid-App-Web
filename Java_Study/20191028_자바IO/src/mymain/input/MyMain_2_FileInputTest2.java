package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_2_FileInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String filename = "src/mymain/input/MyMain_2_FileInputTest.java";

		// 1.파일 열기
		InputStream is = new FileInputStream(filename);

		// byte stream -> char stream 으로 포장
		InputStreamReader isr = new InputStreamReader(is);

		while (true) {
			int ch = isr.read(); //문자스트림을 읽기
			// (EOF)화일 끝이면 종료
			if (ch == -1)
				break;
			System.out.printf("%c", ch);
		}

		// 3.파일 닫기 : 열린 역순으로 닫기!
		isr.close(); // reader파일도 닫아주는 거 잊지말기!
		is.close();
		

	}

	
}
