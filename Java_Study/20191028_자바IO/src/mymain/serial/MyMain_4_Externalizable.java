package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo;
import vo.PersonVo2;

public class MyMain_4_Externalizable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// ����ȭ

		
		 PersonVo2 p = new PersonVo2("ȫ�浿",20,"���� ������"); //��������
		 FileOutputStream fos =new FileOutputStream("person2.dat");
		  
		  //����ȭ ��ü�� Filtering(����) 
		  ObjectOutputStream oos = new ObjectOutputStream(fos);
		  
		  //��ä����
		  oos.writeObject(p);
		  
		 //���� :���ſ��� 
		  oos.close(); fos.close();
		 

		// ������ȭ( �����б� > ��ü����)
		FileInputStream fis = new FileInputStream("person2.dat");

		// byte stream > Object Stream(������ȭ) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// �����б� > ��ü�� ����
		PersonVo2 pp = (PersonVo2) ois.readObject(); // ��� ��ü�� �޾ƾ��ϹǷ� Object�� ��ȯ�ϰ� �� �׷��� ĳ������ �������

		System.out.println("������ ��ü :" + pp);

		// �ݱ� :��������
		ois.close();
		fis.close();

	}

}
