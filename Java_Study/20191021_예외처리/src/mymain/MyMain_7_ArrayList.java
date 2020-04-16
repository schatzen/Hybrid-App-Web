package mymain;

import java.awt.List;
import java.util.ArrayList;

public class MyMain_7_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List���� > ��������
		// �迭 > ���� ����Ʈ

		// Collection
		// �� List (List���� �������̽� : ���Ŵ���)
		// �� ArrayList (Ŭ���� : ���輭)
		// : �����迭 (�ڹ��� ��� ��ü�� �������)
		// (�ڹ��� �ֻ��� Ÿ���� Object������ ����) : �ڹ��� ��� Ÿ���� �����ϱ����ؼ�

		ArrayList list = new ArrayList(); 

		list.add("���ڿ�"); // String 0
		list.add(10); // int > Integer 1
		// 10 > new Integer(10)
		list.add(10.5); // double > Double 2
		// 10.5 > new Double(10.5)
		list.add(true); // boolean > Boolean 3
		// true > new Boolean(true)

		// Auto-Boxing : ��ü������ �ڵ� ���� (JDK 1.5 later)

		System.out.printf("list's size() = %d\n", list.size());

		// String str = list.get(0); > ÷�ڰ� 0�� String �迭 �������� �ϳ�, type�� �ȸ´�.
		String str = (String) list.get(0); // > ���� �̷��� �ٿ�ĳ��������� �Ѵ�.
		Integer nob = (Integer) list.get(1);
		double d = (double) list.get(2);

		Double dob = 1.0; // Double ��ü��, double�� �⺻��. ���� Ÿ���� �ٸ���. �׷��� Auto-Boxing�� �ڹ� ������ ����
							// new Double(1.0) ���ذ���

		// Auto-Unboxing
		double dd = dob; // dob.doubleValue();

		System.out.println(str);
		System.out.println(nob);
		System.out.println(d);

		ArrayList fruit_list = new ArrayList();

		fruit_list.add("���"); // 0
		fruit_list.add("����"); // 1
		fruit_list.add("����"); // 2
		fruit_list.add("����"); // 3
		fruit_list.add("����"); // 4

		for (int i = 0; i < fruit_list.size(); i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d) = %s\n", i, fruit);
		}

		// ����
		fruit_list.remove(2);

		System.out.println("\r\n---after remove---");

		for (int i = 0; i < fruit_list.size(); i++) {
			String fruit = (String) fruit_list.get(i);
			System.out.printf("fruit_list.get(%d) = %s\n", i, fruit);
		}

	}

}
