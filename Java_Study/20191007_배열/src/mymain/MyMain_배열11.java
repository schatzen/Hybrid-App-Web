package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_�迭11 {

	public static void main(String[] args) {
		int[] mr = new int[10];

		// 1���� �迭�����ϴ� ��ü ����

		MyArray ma = new MyArray();
		System.out.println("���ʱⰪ ��¤�");
		ma.displayArray(mr);

		// ������� �� ����
		ma.setArray(mr);
		System.out.println("�Ѱ� ���� �� ��¤�");
		ma.displayArray(mr);

		// ��� �迭���� 1�� ����
		ma.fill(mr, 1);
		System.out.println("�Ѹ�� �� 1�� ����(MyAarray�̿�)��");
		ma.displayArray(mr);

		// ���� API : Arrays class
		Arrays.fill(mr, 3); // Arrays�� 1���� �迭�����ϴ� java�� ����Ǿ��ִ� �ý���..?
		System.out.println("�Ѹ�� �� 3�� ����(Arrays�̿�)��");
		ma.displayArray(mr);
		// 0 1 2 3 4 5 6 7 8 9 10 <- index(÷��)
		// 3 3 3 3 3 3 3 3 3 3 3
		// ���� ����+����
		Arrays.fill(mr, 3, 7, 8); // = Arrays.fill(mr, 3, 3+4, 8);
		System.out.println("�������� ��ġ ���� 8�� �����");
		ma.displayArray(mr);
		
		ma.fil(mr, 2, 2+4, 0);
		System.out.println("�������� ��ġ ���� 0�� ����(MyArray�̿�)��");
		ma.displayArray(mr);

		// ���⿡�� �迭�� ����. �� ����� MyArray����.
		// MyArray ���� displayArray�� �ݹ��� . ar�� �ӽú����� �ٸ� ����.

	}

}
