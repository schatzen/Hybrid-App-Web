package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyMain_3_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �������� ����Ǵ� �����ͱ���
		// HashSet���� �ϸ� ���ڰ����� ����
		// TreeSet�� sort�Ǽ� ����
		Set<String> set = new HashSet<String>(); // HashSet���� �ϸ� ���ڰ����� ����
													// TreeSet�� sort�Ǽ� ����

		set.add("�浿3");
		set.add("�浿4");
		set.add("�浿5");
		set.add("�浿1");
		set.add("�浿2");

		if (set.add("�浿5") == false) // �ߺ��Ǹ� boolean ������ ����
			System.out.println("--�߰�����--");

		System.out.println(set); // HashSet : �������� ����Ǵ� ���� Ȯ�� TreeSet: sort�Ǽ� ������ ���� Ȯ��

		System.out.println("--���� LOOP�̿�");
		for (String name : set)
			System.out.println(name);
		
		//Irator : �ݺ���(�÷��� ������ü)
		System.out.println("--Iterator �̿�--");
		// set => [[�浿1, �浿2, �浿3, �浿4, �浿5]
		Iterator<String> it = set.iterator();

		while (it.hasNext()) { // it ���� ������ �ֳ�? //hasNext �ڼ��� �˾ƺ���!
			String name = it.next(); // ��������
			System.out.println(name);
		}
	}

}
