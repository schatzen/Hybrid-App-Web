package mymain2;

import myutil.MyArray2;

public class MyMain_�迭222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray2 ma2 = new MyArray2();
		//2�����迭 �ʱ�ȭ
		int [][] mm = new int[][] { 
			                        {1,2}, //0�� 
			                        {3,4}  //1��
			                      };
		int[][] mm1 = /* new int[][] */{ 
			        		{1,2,3},
			        		{4,5,6,7},
			        		{8,9,10,11,12}
				       };
        
		System.out.println("--�������� �迭 �ʱ�ȭ--");
        ma2.display(mm);
        System.out.println("--�������� �迭 �ʱ�ȭ--");
        ma2.display(mm1);
        
        
        //��Ʈ���� ��
        int [][] block_1 = {
        		{1,1,1},
        		{0,1,0},
        		{0,1,0}
        };
        
        int [][] block_2 = {
        		{1,1,1},
        		{0,0,1},
        		{0,0,1}
        };
        
        int [][] block_3 = {
        		{1,1,1},
        		{1,0,1},
        		{1,1,1}
        };
        
        System.out.println("== T block ==");
        ma2.display_block(block_1);
        
        System.out.println("== �� block ==");
        ma2.display_block(block_2);
        
        System.out.println("== �� block ==");
        ma2.display_block(block_3);
        
        
        
        
			                      
		
		
	}

}
