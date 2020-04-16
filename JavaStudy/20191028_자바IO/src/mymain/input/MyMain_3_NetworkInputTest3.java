package mymain.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_NetworkInputTest3 {

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
      	
      	BufferedReader br = new BufferedReader(isr);
        
        //읽기
        while(true) {
			
        	String readStr = br.readLine();//1줄씩 읽기
			//Html (EOF)화일끝이면 null 반환
			if(readStr==null)break;
			System.out.println(readStr);
			
			Thread.sleep(10);
			
		}
        
		
	}

}






