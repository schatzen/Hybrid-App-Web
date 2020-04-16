package mymain2;

import myutil.MyArray2;

public class MyMain_배열222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2차원 배열 초기화 
		MyArray2 ma2 = new MyArray2();
		
		int[][] mm = new int [][] {
			{1,2},
			{3,4}
		};
		int [][] mm1 = { //new int[][] 생략
				{1,2,3},
				{4,5,6,7},
				{8,9,10,11,12}
		};
		
		
	System.out.println("ㅡ고정길이 배열 초기화ㅡ");	
	ma2.display(mm);
		
	System.out.println("ㅡ가변길이 배열 초기화ㅡ");
	ma2.display(mm1);
	
	

	}

}
