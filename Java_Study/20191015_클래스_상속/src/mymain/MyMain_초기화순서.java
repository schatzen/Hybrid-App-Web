package mymain;

import myutil.Child;

public class MyMain_�ʱ�ȭ���� {
	
	
	//��Ӱ�ü���� �ʱ�ȭ ������ �θ�ü���� ó��
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child c = new Child();
		c.display_child();

		Child c1 = new Child(200);
		c1.display_child();

		Child c2 = new Child(300, 500);
		c2.display_child();

	}

}
