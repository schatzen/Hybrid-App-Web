package mymain2;

import myutil.MyArray2;

public class MyMain_배열2 {

	public static void main(String[] args) {
		int[][] mm = new int[3][4];

		// 행 열
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

		// 모두 지우기
		ma2.fill(mm, 0);
		System.out.println("--0으로 채우기--");
		ma2.display(mm);
		System.out.println();

		// 지정된 행만 val로 채우기
		ma2.fill(mm, 1, 1);
		System.out.println("--1행을 1로 채우기--");
		ma2.display(mm);

	}

}
