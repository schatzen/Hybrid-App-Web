package mymain.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import vo.PersonVo;

public class MyMain_1_SerializableTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// ����ȭ

		/*
		 * PersonVo p = new PersonVo("ȫ�浿",20,"���� ������"); //�������� FileOutputStream fos =
		 * new FileOutputStream("person.dat");
		 * 
		 * //����ȭ ��ü�� Filtering(����) ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * //��ä���� oos.writeObject(p);
		 * 
		 * //���� :���ſ��� oos.close(); fos.close();
		 */

		// ������ȭ( �����б� > ��ü����)
		FileInputStream fis = new FileInputStream("person.dat");

		// byte stream > Object Stream(������ȭ) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// �����б� > ��ü�� ����
		PersonVo pp = (PersonVo) ois.readObject(); // ��� ��ü�� �޾ƾ��ϹǷ� Object�� ��ȯ�ϰ� �� �׷��� ĳ������ �������

		System.out.println("������ ��ü :" + pp);

		// �ݱ� :��������
		ois.close();
		fis.close();

	}

}
