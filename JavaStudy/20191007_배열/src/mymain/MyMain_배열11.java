package mymain;

import java.util.Arrays;

import myutil.MyArray;

public class MyMain_배열11 {

	public static void main(String[] args) {
		
		int [] mr = new int[10];
 		//1차원배열관리하는 객체생성
        MyArray	 ma = new MyArray();
        
        System.out.println("--초기값 출력--");
        ma.displayArray(mr);
        
        //순서대로 값셋팅
        ma.setArray(mr);
        System.out.println("--값 설정후 출력--");
        ma.displayArray(mr);
        
        //모든배열값을 1로 셋팅
        ma.fill(mr, 1);
        System.out.println("--모든값 1로 셋팅(MyArray이용)--");
        ma.displayArray(mr);
        
        //기존 API : Arrays class
        Arrays.fill(mr, 3);
        System.out.println("--모든값 3로 셋팅(Arrays이용)--");
        ma.displayArray(mr);
        //  0 1 2 3 4 5 6 7 8 9 <=index(첨자) 
        //  3 3 0 0 0 0 8 3 3 3
        
        //              시작 시작+갯수   
        Arrays.fill(mr,   3,    3+4,   8);
        System.out.println("--지정된 위치값을 8로 변경--");
        ma.displayArray(mr);
        
        ma.fill(mr, 2, 2+4, 0);
        System.out.println("--지정된 위치값을 0로 변경(MyArray)--");
        ma.displayArray(mr);
        
        
        
        
        
        
        
        
        
        
        
		
		
		
	}
}
