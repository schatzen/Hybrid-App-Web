package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vo.PersonVo3;

public class MyMain_2_0_ExternalizableTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		PersonVo3 p = 
			new PersonVo3("ȫ�浿", 20, "���� ������ ���굿");
		//ȭ������
		FileOutputStream fos = new FileOutputStream("person3.dat");
		
		//����ȭ ��ü�� Filtering(����)
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//��ü����
		oos.writeObject(p);		
		
		//�ݱ�: ���⿪��
		oos.close();
		fos.close();
		System.out.println("--����Ϸ�--");
		
		
		//������ȭ(ȭ���б�->��ü����)
		FileInputStream fis = new FileInputStream("person3.dat");
		
		//byte stream-> Object Stream(������ȭ) Filtering
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//ȭ���б�->��ü�� ����
		PersonVo3 pp =  (PersonVo3) ois.readObject();
		
		System.out.println("������ ��ü: " + pp);
		
		//�ݱ�:��������
		ois.close();
		fis.close();
		
		
		
		
	}

}
