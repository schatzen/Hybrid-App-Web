package mymain.input;

import java.io.InputStream;
import java.net.URL;

public class MyMain_3_NetworkInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String str_url = "https://www.naver.com/";

		// Uniform Resource Locator (자원의 위치를 표현)
		URL url = new URL(str_url);

		InputStream is = url.openStream();

		while (true) {
			int ch = is.read();
			// Html (EOF) 파일 끝이면 -1 반환
			if (ch == -1)
				break;
			System.out.printf("%c", ch);
		}

	}

}
