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
		
		// ����ȭ �ȵǴ� ��ü
		// => Image image;
		
	    /*	
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		p_list.add(new PersonVo("�ϱ浿", 21, "���� ���� ����1��"));
		p_list.add(new PersonVo("�̱浿", 22, "���� ���� ����2��"));
		p_list.add(new PersonVo("��浿", 23, "���� ���� ����3��"));
		p_list.add(new PersonVo("��浿", 24, "���� ���� ����4��"));
		p_list.add(new PersonVo("���浿", 25, "���� ���� ����5��"));
		
		FileOutputStream fos = new FileOutputStream("person_list.dat");
		
		//Filtering: ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//����
		oos.writeObject(p_list);
				
		//�ݱ�:���⿪��
		oos.close();
		fos.close();
		
		System.out.println("--����Ϸ�--");
		*/
		
		
		//������ȭ(����)
		FileInputStream fis = new FileInputStream("person_list.dat");
		
		//byte stream-> Object Stream(������ȭ) Filtering
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//ȭ���б�->��ü�� ����
		List<PersonVo>  p_list2=  (List<PersonVo>) ois.readObject();
		
		//System.out.println("������ ��ü: " + p_list2);
		System.out.println("--������ ��ü--");
		for(PersonVo p : p_list2) {
			System.out.println(p);
		}
		
		
		//�ݱ�:��������
		ois.close();
		fis.close();
		
		
		
		
	}

}
