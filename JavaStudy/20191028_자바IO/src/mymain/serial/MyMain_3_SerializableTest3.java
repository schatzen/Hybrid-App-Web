package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_3_SerializableTest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
     /*
		Map infoMap 
		         = new HashMap();
		
		infoMap.put("name", "�ڱ浿");
		infoMap.put("company", "������");
		infoMap.put("age", 20);
		String [] hobby_array = {"����","�","����"};
		infoMap.put("hobby", hobby_array);
		
		List<PersonVo> friend_list = new ArrayList<PersonVo>();
		friend_list.add(new PersonVo("ģ��1", 20, "���굿"));
		friend_list.add(new PersonVo("ģ��2", 21, "���굿"));
		friend_list.add(new PersonVo("ģ��3", 19, "���굿"));
		infoMap.put("friend", friend_list);
		
		//1. ����
		FileOutputStream fos = new FileOutputStream("infoMap.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(infoMap);
		
		oos.close();
		fos.close();
	*/
				
		//2. �б�
		FileInputStream fis = new FileInputStream("infoMap.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//������ȭ(����)
		Map readMap = (Map) ois.readObject();
		
		//Map���κ��� �� �о����
		String name = (String) readMap.get("name");
		int age = (int) readMap.get("age");
		String company = (String) readMap.get("company");
		String [] hobby_array2 = (String[]) readMap.get("hobby");
		List<PersonVo> friend_list2 = (List<PersonVo>) readMap.get("friend");
				
		System.out.println("--������ ������--");
		System.out.printf("�̸�:%s\n",name);
		System.out.printf("����:%d\n",age);
		System.out.printf("ȸ��:%s\n",company);
		System.out.printf("���:");
		for(String hobby : hobby_array2) {
			System.out.print(hobby + " ");
		}
		System.out.println();
		
		System.out.printf("ģ��:");
		for(PersonVo friend : friend_list2) {
			System.out.print(friend.getName()+ " ");
		}
		
		System.out.println();
		
		
		
		
		
		
		
		ois.close();
		fis.close();
		
		
		
	}

}
