package mymain.input;

import java.io.InputStream;

public class MyMain_1_KeyboardInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Ű������ġ�� �Է½�Ʈ�� ���
		InputStream is = System.in;
		System.out.println("����:Ctrl+Z");
		while(true) {
			int ch = is.read();
			//Ctrl+Z ������ -1��ȯ
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
		
		
		
	}

}
