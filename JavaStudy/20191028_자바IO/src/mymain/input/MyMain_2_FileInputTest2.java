package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_2_FileInputTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        String filename = 
        "src/mymain/input/MyMain_2_FileInputTest.java";		
		//1.ȭ�Ͽ���
        InputStream is 
		    = new FileInputStream(filename);
        
        //byte stream-> char stream���� ����
      	InputStreamReader isr = new InputStreamReader(is);
        
        //2.�б�
        while(true) {
			int ch = isr.read();//���ڽ�Ʈ���� �б�
			//(EOF)ȭ�ϳ��̸� -1��ȯ
			if(ch==-1)break;
			System.out.printf("%c",ch);
		}
                
        
        //3.�ݱ�: ���� �������� �ݴ´�
        isr.close();
        is.close();
		
		
		
	}

}
