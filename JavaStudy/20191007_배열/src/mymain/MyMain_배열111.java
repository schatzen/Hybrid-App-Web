package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_�迭111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray ma = new MyArray();
		
		//�迭 �ʱ�ȭ
		// int [] mr = new int[]{ 1,2,3,4,5 };
		//  �����ϸ� ������ new int[] ó��
		int [] mr = { 10,2,13,4,15 };
		
		System.out.println("---before sort---");
		ma.displayArray(mr);
		
		//Arrays ����� sort��� Ȱ��
		Arrays.sort(mr);//��������(ascending sort)
		System.out.println("---after asc sort---");
		ma.displayArray(mr);
		
		//���� ���� MyArray�̿� ��������
		ma.sort_desc(mr);
		System.out.println("---after desc sort---");
		ma.displayArray(mr);
		
		
		
	}

}
