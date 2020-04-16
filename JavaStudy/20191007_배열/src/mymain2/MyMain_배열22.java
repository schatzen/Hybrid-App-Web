package mymain2;

import myutil.MyArray2;

public class MyMain_배열22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyArray2 ma2 = new MyArray2();
		
		//고정길이 배열 : 열의갯수(길이)가 동일한 배열
		int [][] mm = new int[3][4];
		
		//가변길이 배열 : 열의갯수가 가변적인 배열
		int [][] mm2 = new int[3][];
		
		mm2[0] = new int[]{1,2};
		mm2[1] = new int[]{3,4,5};
		mm2[2] = new int[]{6,7,8,9};
		
		ma2.display(mm2);
		
		
		
		
	}

}
