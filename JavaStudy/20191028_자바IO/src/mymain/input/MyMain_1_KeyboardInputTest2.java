package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_KeyboardInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Ű������ġ�� �Է½�Ʈ�� ���
		InputStream is = System.in;
		
		//byte stream-> char stream���� ����
		InputStreamReader isr = new InputStreamReader(is);
		
		System.out.println("����:Ctrl+Z");
		while(true) {
			int ch = isr.read();//Reader�κ��� �о����
			//Ctrl+Z ������ -1��ȯ
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
		
		
		
	}

}
