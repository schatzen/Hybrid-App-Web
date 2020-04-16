package mymain;

import myutil.Child;
import myutil.Parent;

public class MyMain_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Parent p = new Child();
        
        p.sub();//Child.sub() call(재정의 메소드)
        
        p.sub(10);
        
        p.hi();
        
        
        //down-casting(사용범위 Child영역까지 확장)
        ((Child)p).sub2();
        
        Child c =new Child();
        c.hi();
        
         
        
        
        
	}

}
