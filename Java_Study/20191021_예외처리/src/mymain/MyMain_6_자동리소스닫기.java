package mymain;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyMain_6_�ڵ����ҽ��ݱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//JDK7.0 later����
		try (
				FileInputStream fis = new FileInputStream("a.txt");
				FileOutputStream ios = new FileOutputStream("actxt");
				//���� ���� 2���� ���ҽ��� �ڵ����� �ݾ��ش�.
				) {
			
			// ���ڵ� ����
			
		} catch (Exception e) {

		}
	}
}
