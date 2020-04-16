package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyMain_2_FileInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String filename = "src/mymain/input/MyMain_2_FileInputTest.java";

		// 1.파일 열기
		InputStream is = new FileInputStream(filename);

		while (true) {
			int ch = is.read();
			// (EOF)화일 끝이면 종료
			if (ch == -1)
				break;
			System.out.printf("%c", ch);
		}

		// 3.파일 닫기
		is.close();

	}

}
