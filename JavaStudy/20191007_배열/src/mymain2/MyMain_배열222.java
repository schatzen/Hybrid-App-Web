package mymain2;

import myutil.MyArray2;

public class MyMain_배열222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray2 ma2 = new MyArray2();
		//2차원배열 초기화
		int [][] mm = new int[][] { 
			                        {1,2}, //0행 
			                        {3,4}  //1행
			                      };
		int[][] mm1 = /* new int[][] */{ 
			        		{1,2,3},
			        		{4,5,6,7},
			        		{8,9,10,11,12}
				       };
        
		System.out.println("--고정길이 배열 초기화--");
        ma2.display(mm);
        System.out.println("--가변길이 배열 초기화--");
        ma2.display(mm1);
        
        
        //테트리스 블럭
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
        
        System.out.println("== ㄱ block ==");
        ma2.display_block(block_2);
        
        System.out.println("== □ block ==");
        ma2.display_block(block_3);
        
        
        
        
			                      
		
		
	}

}
