package mymain2;

import myutil.MyArray2;

public class MyMain_�迭22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyArray2 ma2 = new MyArray2();
		
		//�������� �迭 : ���ǰ���(����)�� ������ �迭
		int [][] mm = new int[3][4];
		
		//�������� �迭 : ���ǰ����� �������� �迭
		int [][] mm2 = new int[3][];
		
		mm2[0] = new int[]{1,2};
		mm2[1] = new int[]{3,4,5};
		mm2[2] = new int[]{6,7,8,9};
		
		ma2.display(mm2);
		
		
		
		
	}

}
