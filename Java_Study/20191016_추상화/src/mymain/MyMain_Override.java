package mymain;

import myutil.Child;
import myutil.Parent;

public class MyMain_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Child();

		p.sub();
		// --Child.sub() call-- 출력o (마지막에 재정의된 메소드를 호출하기때문)
		// --Parent.sub() call-- 출력x

		p.sub(10);
		// --Parent.sub(int n) call-- 출력 Child에 sub(int n) 메소드 없기 때문..!
		
		p.hi(); //재정의 시스템 때문에 하이방가가 나옴

		((Child) p).sub2(); // down-casting (사용범위 Child로 확장)
		// p.sub2(); 는 출력 못함 > sub2()은 오로지 child의 메소드이기 때문
		
		Child c = new Child();
		c.hi();
		
		
		
	}
		

}
