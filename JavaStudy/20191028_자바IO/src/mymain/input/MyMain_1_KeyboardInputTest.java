package mymain.input;

import java.io.InputStream;

public class MyMain_1_KeyboardInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//키보드장치의 입력스트림 얻기
		InputStream is = System.in;
		System.out.println("종료:Ctrl+Z");
		while(true) {
			int ch = is.read();
			//Ctrl+Z 누르면 -1반환
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
		
		
		
	}

}
