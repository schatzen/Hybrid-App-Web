package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class MyMain_2_FileInputTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String filename = 
        "src/mymain/input/MyMain_2_FileInputTest.java";		
		//1.ȭ�Ͽ���
        InputStream is 
		    = new FileInputStream(filename);
        
        //2.�б�
        while(true) {
			int ch = is.read();
			//(EOF)ȭ�ϳ��̸� -1��ȯ
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
                
        
        //3.�ݱ�
        is.close();
		
		
		
	}

}
