package mymain.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_3_SerializableTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 
		 * Map infoMap = new HashMap();
		 * 
		 * infoMap.put("name", "�ڱ浿"); infoMap.put("company", "������"); infoMap.put("age",
		 * 20);
		 * 
		 * String[] hobby_array = { "����", "�", "����" }; infoMap.put("hobby",
		 * hobby_array);
		 * 
		 * List<PersonVo> friend_list = new ArrayList<PersonVo>(); friend_list.add(new
		 * PersonVo("ģ��1", 20, "���굿")); friend_list.add(new PersonVo("ģ��2", 19,
		 * "���굿")); friend_list.add(new PersonVo("ģ��3", 21, "���굿"));
		 * infoMap.put("friend", friend_list);
		 * 
		 * 
		 * // 1. ����
		 * 
		 * FileOutputStream fos = new FileOutputStream("map_list.dat");
		 * 
		 * // Filtering : ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * // ���� oos.writeObject(infoMap);
		 * 
		 * // �ݱ� : ���ſ��� oos.close(); fos.close();
		 * 
		 * 
		 * System.out.println("--����Ϸ�--");
		 */

		// 2. �б�

		// ������ȭ( �����б� > ��ü����)
		FileInputStream fis = new FileInputStream("map_list.dat");

		// byte stream > Object Stream(������ȭ) filtering
		ObjectInputStream ois = new ObjectInputStream(fis);

		// �����б� > ��ü�� ����
		// List pp = (ArrayList) ois.readObject(); // ��� ��ü�� �޾ƾ��ϹǷ� Object�� ��ȯ�ϰ� �� �׷���
		// ĳ������ �������
		Map pp = (Map) ois.readObject();

		System.out.println("������ ��ü ");

		System.out.println("�̸�:" + (String) pp.get("name"));
		System.out.println("����:" + (String) pp.get("company"));
		System.out.println("����:" + (Integer) pp.get("age"));

		String[] hobby_array2 = (String[]) pp.get("hobby");
		List<PersonVo> friend_list2 = (List<PersonVo>) pp.get("friend");

		for (String hobby : hobby_array2)
			System.out.println(hobby);
		for (PersonVo p : friend_list2)
			System.out.println(p);

		// �ݱ� :��������
		ois.close();
		fis.close();

	}

}
