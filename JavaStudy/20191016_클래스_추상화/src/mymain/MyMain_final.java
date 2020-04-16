package mymain;

/*
 
 final
 1.변수:  final 자료형 변수명=값;
          (상수선언)  
 2.메소드: final 자료형 메소드명()
          (더이상 재정의 하지 말아라)  
 3.클래스: final class 클래명          
          (상속하지 말아라)  
 */

class A{
	void sub() {}
	final void sub1() {}
}

final class B extends A{
	void sub() {}
	//void sub1() {} // final method이기때문에 재정의 불가
}

// class C extends B{}
// class MyString extends String {}



public class MyMain_final {
	//상수선언
    public final static String PROGRAM_NAME ="final 연습";
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(MyMain_final.PROGRAM_NAME); 
        //MyMain_final.PROGRAM_NAME= "연습 final";
	}

}
