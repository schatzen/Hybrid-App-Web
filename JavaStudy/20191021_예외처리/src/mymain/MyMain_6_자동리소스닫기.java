package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class MyMain_6_�ڵ����ҽ��ݱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//JDK7.0 later���� 
		try(
				FileReader fr = new FileReader("a.txt");
				FileWriter fw = new FileWriter("c.txt")
				//���翭�� 2���� ���ҽ��� �ڵ����� �ݾ��ش�		
		   ){
			
			//���ڵ� ����
			while(true) {
				int ch = fr.read();
				if(ch==-1)break;
				//�������ڸ� ����
				fw.write(ch);
			}
			
			System.out.println("--����Ϸ�--");
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
