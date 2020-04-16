package mymain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMain_5_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null; // file �д� ��ü
		FileWriter fw = null; // file ���� ��ü

		try { // ���ڵ�
			fr = new FileReader("a.txt"); // �б����� ����
			fw = new FileWriter("b.txt"); // �������� ����
			
			
			while (true) {
				int ch = fr.read(); //�̰͵� ���� ����ó�� ������ϴµ� �ؿ��� catch�����ϱ� ���� �� �ʿ� x
				if(ch ==-1) break; //������ �о����� ����������
				//���� ���ڸ� ����
				fw.write(ch);
			}
			System.out.println("����Ϸ�"); 

		} catch (Exception e) { // ���ܰ� �߻��ϸ�

		} finally { //alt + shift + z : try catch block
					//���������� ����  ���ȵ�, ������ ����� ������ �ݾƾ��ϴϱ� �̋� finally�� ó��!
			try {
				// ���ܹ߻� ������ ������� ������ ȣ��
				if (fr != null) fr.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
