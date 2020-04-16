package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyMain_6_자동리소스닫기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//JDK7.0 later지원
		try (
				FileInputStream fis = new FileInputStream("a.txt");
				FileOutputStream ios = new FileOutputStream("actxt");
				//현재 열린 2개의 리소스를 자동으로 닫아준다.
				) {
			
			// 본코드 수행
			
		} catch (Exception e) {

		}
	}
}
