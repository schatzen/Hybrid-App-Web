package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_NetworkInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String str_url = "https://www.naver.com/";
        
        //Uniform Resource Locator(�ڿ��� ��ġ�� ǥ��)
        URL url = new URL(str_url);
        
        InputStream is = url.openStream();
        
        //byte stream-> char stream���� ����
      	InputStreamReader isr 
      	    = new InputStreamReader(is,"utf-8");
     
      	// charset   euc-kr(MS949)    utf-8    ISO_8859_1
      	// '��'      100              1000     2000    
      	
        
        //�б�
        while(true) {
			int ch = isr.read(); //���ڽ�Ʈ��
			//Html (EOF)ȭ�ϳ��̸� -1��ȯ
			if(ch==-1)break;
			System.out.printf("%c",ch);
			
			//Thread.sleep(1);
			
		}
        
		
	}

}






