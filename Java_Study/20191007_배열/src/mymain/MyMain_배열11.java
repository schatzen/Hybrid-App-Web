package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_배열11 {

	public static void main(String[] args) {
		int[] mr = new int[10];

		// 1차원 배열관리하는 객체 생성

		MyArray ma = new MyArray();
		System.out.println("ㅡ초기값 출력ㅡ");
		ma.displayArray(mr);

		// 순서대로 값 세팅
		ma.setArray(mr);
		System.out.println("ㅡ값 설정 후 출력ㅡ");
		ma.displayArray(mr);

		// 모든 배열값을 1로 세팅
		ma.fill(mr, 1);
		System.out.println("ㅡ모든 값 1로 세팅(MyAarray이용)ㅡ");
		ma.displayArray(mr);

		// 기존 API : Arrays class
		Arrays.fill(mr, 3); // Arrays는 1차원 배열관리하는 java에 내재되어있는 시스템..?
		System.out.println("ㅡ모든 값 3로 세팅(Arrays이용)ㅡ");
		ma.displayArray(mr);
		// 0 1 2 3 4 5 6 7 8 9 10 <- index(첨자)
		// 3 3 3 3 3 3 3 3 3 3 3
		// 시작 시작+개수
		Arrays.fill(mr, 3, 7, 8); // = Arrays.fill(mr, 3, 3+4, 8);
		System.out.println("ㅡ지정된 위치 값을 8로 변경ㅡ");
		ma.displayArray(mr);
		
		ma.fil(mr, 2, 2+4, 0);
		System.out.println("ㅡ지정된 위치 값을 0로 변경(MyArray이용)ㅡ");
		ma.displayArray(mr);

		// 여기에선 배열만 생성. 값 제어는 MyArray에서.
		// MyArray 에서 displayArray를 콜백함 . ar은 임시변수와 다름 없다.

	}

}
