package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_2_SerializableTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// ����ȭ �ȵǴ� ��ü �� �ϳ�
		// Image image;
		/*
		 * 
		 * List<PersonVo> p_list = new ArrayList<PersonVo>(); p_list.add(new
		 * PersonVo("�ϱ浿", 20, "���� ������ ����1��")); p_list.add(new PersonVo("�̱浿", 21,
		 * "���� ������ ����2��")); p_list.add(new PersonVo("��浿", 22, "���� ������ ����3��"));
		 * p_list.add(new PersonVo("��浿", 23, "���� ������ ����4��")); p_list.add(new
		 * PersonVo("���浿", 24, "���� ������ ����5��"));
		 * 
		 * FileOutputStream fos = new FileOutputStream("person_list.dat");
		 * 
		 * // Filtering : ObjectOutputStream ObjectOutputStream oos = new
		 * ObjectOutputStream(fos);
		 * 
		 * // ���� oos.writeObject(p_list);
		 * 
		 * // �ݱ� : ���ſ��� oos.close(); fos.close();
		 * 
		 * System.out.println("--����Ϸ�--");
		 */

		// ������ȭ( �����б� > ��ü����)
		FileInputStream fis = new FileInputStream("person_list.dat");

		// byte stream > Object Stream(������ȭ) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// �����б� > ��ü�� ����
		//List pp = (ArrayList) ois.readObject(); // ��� ��ü�� �޾ƾ��ϹǷ� Object�� ��ȯ�ϰ� �� �׷��� ĳ������ �������
		List<PersonVo> pp = (List<PersonVo>) ois.readObject();

		//System.out.println("������ ��ü :" + pp);
		System.out.println("������ ��ü");
		for(PersonVo p : pp) {
			System.out.println(p);
		}

		// �ݱ� :��������
		ois.close();
		fis.close();

	}

}
