package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_NetworkInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String str_url = "https://www.naver.com/";

		// Uniform Resource Locator (자원의 위치를 표현)
		URL url = new URL(str_url);

		InputStream is = url.openStream();

		// byte stream -> char stream 으로 포장
		InputStreamReader isr = new InputStreamReader(is,"utf-8"); //내가 읽은 데이터를 인코딩 utf-8로 전환
		
		//          	 한글만호환			 네트워크(네이버) 모든언어호환
		// charset 		euc-kr(MS949) 		utf-8	 					Iso8859_1
		// '가' 			  100 				1000 							2000

		while (true) {
			int ch = isr.read();// 문자 스트림으로 읽기
			// Html (EOF) 파일 끝이면 -1 반환
			if (ch == -1)
				break;
			System.out.printf("%c", ch);
			
			Thread.sleep(1);
		}

	}

}
