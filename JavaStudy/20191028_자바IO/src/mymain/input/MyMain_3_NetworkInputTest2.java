package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_NetworkInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String str_url = "https://www.naver.com/";
        
        //Uniform Resource Locator(자원의 위치를 표현)
        URL url = new URL(str_url);
        
        InputStream is = url.openStream();
        
        //byte stream-> char stream으로 포장
      	InputStreamReader isr 
      	    = new InputStreamReader(is,"utf-8");
     
      	// charset   euc-kr(MS949)    utf-8    ISO_8859_1
      	// '가'      100              1000     2000    
      	
        
        //읽기
        while(true) {
			int ch = isr.read(); //문자스트림
			//Html (EOF)화일끝이면 -1반환
			if(ch==-1)break;
			System.out.printf("%c",ch);
			
			//Thread.sleep(1);
			
		}
        
		
	}

}






