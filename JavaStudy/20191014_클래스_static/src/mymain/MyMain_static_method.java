package mymain;

import myutil.MyMath;

public class MyMain_static_method {

	/*
	  static method는 객체생성없이
	  클래스명.메소드명()사용한다
	  MyMath용도: 서비스기능(Method)만 처리하는 객체
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10,b=5,res;
		res = MyMath.plus(a, b);
		
	    System.out.printf("%d + %d = %d\n",a,b,res);
	    
	    //객체생성을 하지 못하도록 설정(private생성자)
	    //MyMath mm = new MyMath();
	   
	    
	    res = MyMath.max(a, b);
	    System.out.printf("%d,%d중 큰수는 %d\n",a,b,res);
	    
	    //기존API max사용
	    //Math m = new Math();
	    
	    res = Math.max(a, b);
	    System.out.printf("%d,%d중 큰수는 %d\n",a,b,res);
	    		
		
	}

}
