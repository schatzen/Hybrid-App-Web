package mymain;

import myutil.Child;
import myutil.Parent;

public class MyMain_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Child();

		p.sub();
		// --Child.sub() call-- ���o (�������� �����ǵ� �޼ҵ带 ȣ���ϱ⶧��)
		// --Parent.sub() call-- ���x

		p.sub(10);
		// --Parent.sub(int n) call-- ��� Child�� sub(int n) �޼ҵ� ���� ����..!
		
		p.hi(); //������ �ý��� ������ ���̹氡�� ����

		((Child) p).sub2(); // down-casting (������ Child�� Ȯ��)
		// p.sub2(); �� ��� ���� > sub2()�� ������ child�� �޼ҵ��̱� ����
		
		Child c = new Child();
		c.hi();
		
		
		
	}
		

}
