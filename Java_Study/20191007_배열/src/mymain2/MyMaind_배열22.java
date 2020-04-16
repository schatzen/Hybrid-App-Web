package mymain2;

import myutil.MyArray2;

public class MyMaind_배열22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 고정길이 배열: 열의 개수(길이)가 동일한 배열
		int [][] mm = new int[3][4];
		
		//가변길이 배열 : 열의 개수가 가변적인 배열

		int [][] mm2 = new int[3][];
		
		mm2[0] = new int[] {1,2}; //1차원배열 초기화  // new int[] 생략x
		mm2[1] = new int[] {3,4,5};
		mm2[2] = new int[] {6,7,8,9};
		
		MyArray2 ma2 = new MyArray2();
		ma2.display(mm2);
		System.out.println();
		
		//테트리스 블럭
		int [][] block_1 = {
				{1,1,1},
				{0,1,0},
				{0,1,0},
			};
		
		int [][] block_2 = {
				{1,1,1},
				{0,0,1},
				{0,0,1},
			};
		
		int [][] block_3 = {
				{1,1,1},
				{1,0,1},
				{1,1,1},
			};
		
		System.out.println("--T block--");
		ma2.display_block(block_1);
		System.out.println();
		
		System.out.println("--ㄱ block--");
		ma2.display_block(block_2);
		System.out.println();
		
		System.out.println("--□ block--");
		ma2.display_block(block_3);
		System.out.println();
		
	}

}
