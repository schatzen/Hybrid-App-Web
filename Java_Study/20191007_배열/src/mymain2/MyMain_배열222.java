package mymain2;

import myutil.MyArray2;

public class MyMain_�迭222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2���� �迭 �ʱ�ȭ 
		MyArray2 ma2 = new MyArray2();
		
		int[][] mm = new int [][] {
			{1,2},
			{3,4}
		};
		int [][] mm1 = { //new int[][] ����
				{1,2,3},
				{4,5,6,7},
				{8,9,10,11,12}
		};
		
		
	System.out.println("�Ѱ������� �迭 �ʱ�ȭ��");	
	ma2.display(mm);
		
	System.out.println("�Ѱ������� �迭 �ʱ�ȭ��");
	ma2.display(mm1);
	
	

	}

}
