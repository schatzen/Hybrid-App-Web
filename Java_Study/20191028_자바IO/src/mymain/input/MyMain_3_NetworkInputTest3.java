package mymain.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_NetworkInputTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String str_url = "https://www.naver.com/";

		// Uniform Resource Locator (�ڿ��� ��ġ�� ǥ��)
		URL url = new URL(str_url);

		InputStream is = url.openStream();

		// byte stream -> char stream ���� ����
		InputStreamReader isr = new InputStreamReader(is,"utf-8"); //���� ���� �����͸� ���ڵ� utf-8�� ��ȯ
		
		//          	 �ѱ۸�ȣȯ			 ��Ʈ��ũ(���̹�) �����ȣȯ
		// charset 		euc-kr(MS949) 		utf-8	 					Iso8859_1
		// '��' 			  100 				1000 							2000
		
		
		BufferedReader br = new BufferedReader(isr);

		while (true) {
			String readStr = br.readLine(); // 1�پ� �б�
			// Html (EOF) ���� ���̸� null�� ��ȯ
			if (readStr == null)
				break;
			System.out.println(readStr);
			
			Thread.sleep(1000);
		}

	}

}
