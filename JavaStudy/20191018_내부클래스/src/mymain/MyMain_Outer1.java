package mymain;

import myutil.Outer1;

public class MyMain_Outer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //
		Outer1 out1 = new Outer1();//�ܺΰ�ü����
		//������ �ܺΰ�ü�� ���ؼ� ���ΰ�ü ����
        Outer1.Inner1 inner1 = out1.new Inner1();
        inner1.display();
        
        Outer1.Inner1 inner1_1 = new Outer1().new Inner1();
 
        
        Outer1.Inner2 inner2 = new Outer1.Inner2();
        inner2.display();
        
        //���ó���Ŭ���� �׽�Ʈ
        new Outer1().method();
        
        //�͸���Ŭ���� �׽�Ʈ
        new Outer1().method2();
	}

}
