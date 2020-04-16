package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_KeyboardInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//키보드장치의 입력스트림 얻기
		InputStream is = System.in;
		
		//byte stream-> char stream으로 포장
		InputStreamReader isr = new InputStreamReader(is);
		
		System.out.println("종료:Ctrl+Z");
		while(true) {
			int ch = isr.read();//Reader로부터 읽어오기
			//Ctrl+Z 누르면 -1반환
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
		
		
		
	}

}
