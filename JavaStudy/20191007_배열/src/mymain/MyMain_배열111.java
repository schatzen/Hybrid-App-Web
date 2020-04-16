package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_배열111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray ma = new MyArray();
		
		//배열 초기화
		// int [] mr = new int[]{ 1,2,3,4,5 };
		//  생략하면 묵시적 new int[] 처리
		int [] mr = { 10,2,13,4,15 };
		
		System.out.println("---before sort---");
		ma.displayArray(mr);
		
		//Arrays 기능중 sort기능 활용
		Arrays.sort(mr);//오름차순(ascending sort)
		System.out.println("---after asc sort---");
		ma.displayArray(mr);
		
		//내가 만든 MyArray이용 내림차순
		ma.sort_desc(mr);
		System.out.println("---after desc sort---");
		ma.displayArray(mr);
		
		
		
	}

}
