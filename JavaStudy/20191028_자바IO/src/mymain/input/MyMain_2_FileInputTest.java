package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyMain_2_FileInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String filename = 
        "src/mymain/input/MyMain_2_FileInputTest.java";		
		//1.화일열기
        InputStream is 
		    = new FileInputStream(filename);
        
        //2.읽기
        while(true) {
			int ch = is.read();
			//(EOF)화일끝이면 -1반환
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
                
        
        //3.닫기
        is.close();
		
		
		
	}

}
