package mymain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMain_5_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;//�����д� ��ü
		FileWriter fw = null;//���Ͼ��� ��ü
		
		try {
			//���ڵ�
			fr = new FileReader("a.txt");//�б�ȭ�� ����
			fw = new FileWriter("b.txt");//����ȭ�� ����
			
			while(true) {
				int ch = fr.read();
				if(ch==-1)break;
				//�������ڸ� ����
				fw.write(ch);
			}
			
			System.out.println("--����Ϸ�--");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//���ܰ� �߻��Ǹ�
			
			
		} finally {
			try {
				//���ܹ߻� ������ ������� ������ ó��
				if(fr!=null)fr.close();
				if(fw!=null)fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
