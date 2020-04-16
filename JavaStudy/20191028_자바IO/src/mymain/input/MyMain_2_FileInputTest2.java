package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_2_FileInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String filename = 
        "src/mymain/input/MyMain_2_FileInputTest.java";		
		//1.화일열기
        InputStream is 
		    = new FileInputStream(filename);
        
        //byte stream-> char stream으로 포장
      	InputStreamReader isr = new InputStreamReader(is);
        
        //2.읽기
        while(true) {
			int ch = isr.read();//문자스트림을 읽기
			//(EOF)화일끝이면 -1반환
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
                
        
        //3.닫기: 열린 역순으로 닫는다
        isr.close();
        is.close();
		
		
		
	}

}
