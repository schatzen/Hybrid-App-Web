package mymain;

import myutil.Child;
import myutil.Parent;

public class MyMain_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Parent p = new Child();
        
        p.sub();//Child.sub() call(������ �޼ҵ�)
        
        p.sub(10);
        
        p.hi();
        
        
        //down-casting(������ Child�������� Ȯ��)
        ((Child)p).sub2();
        
        Child c =new Child();
        c.hi();
        
         
        
        
        
	}

}
