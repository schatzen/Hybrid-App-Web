package mymain2;

import myutil.MyArray2;

public class MyMain_�迭2 {

	public static void main(String[] args) {
		int[][] mm = new int[3][4];

		// �� ��
		/*
		 * mm[0][0]=1; mm[0][1]=2; mm[0][2]=3; mm[0][3]=4;
		 * 
		 * mm[1][0]=5; mm[1][1]=6; mm[1][2]=7; mm[1][3]=8;
		 * 
		 * mm[2][0]=9; mm[2][1]=10; mm[2][2]=11; mm[2][3]=12;
		 */

		MyArray2 ma2 = new MyArray2();
		ma2.setArray(mm);
		ma2.display(mm);
		System.out.println();

		// ��� �����
		ma2.fill(mm, 0);
		System.out.println("--0���� ä���--");
		ma2.display(mm);
		System.out.println();

		// ������ �ุ val�� ä���
		ma2.fill(mm, 1, 1);
		System.out.println("--1���� 1�� ä���--");
		ma2.display(mm);

	}

}
