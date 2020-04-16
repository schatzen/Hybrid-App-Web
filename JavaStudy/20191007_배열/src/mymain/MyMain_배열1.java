package mymain;

public class MyMain_배열1 {

	
	
	/* 오늘부터 배열에 대하여 공부를 합니다 */
	
	// 블럭지정위치 주석 달기: Ctrl + Shift + /
	// 블럭지정위치 주석 해제: Ctrl + Shift + \ 
	
	
	public static void display_array(int [] mr2) {
		                          // int [] mr2 = mr
		System.out.printf("mr2's length=%d\n", mr2.length);
		System.out.print("[ ");
		for(int i=0;i<mr2.length;i++) {
			System.out.print(mr2[i] + " ");
		}
		System.out.println("]");
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1차원 배열참조 선언
		int [] mr;
		
		//1차원 배열 생성
		mr = new int[4];
		
		
		System.out.printf("mr's length=%d\n", mr.length);
		
		//각요소에 값을 넣기
		//첨자 = 첨자+1
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;
		
		//배열사용시 장점
		// 1.일괄처리   
		// 2.손쉽게 집합데이터(배열)  다른객체에게 전달
		
		//반복문을 이용해서 일괄처리
		for(int i=0;i< mr.length ;i++) { //i = 0 1 2 3
			mr[i] = i + 1;
			System.out.printf("mr[%d]=%d\n", i, mr[i]);
		}
		
		
		display_array(mr);
		
		
		
		
	}

}
