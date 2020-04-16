package mymain;

import myutil.Outer1;

public class MyMain_Outer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //
		Outer1 out1 = new Outer1();//외부객체생성
		//생성된 외부객체를 통해서 내부객체 생성
        Outer1.Inner1 inner1 = out1.new Inner1();
        inner1.display();
        
        Outer1.Inner1 inner1_1 = new Outer1().new Inner1();
 
        
        Outer1.Inner2 inner2 = new Outer1.Inner2();
        inner2.display();
        
        //로컬내부클래스 테스트
        new Outer1().method();
        
        //익명내부클래스 테스트
        new Outer1().method2();
	}

}
