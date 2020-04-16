package mymain;

import myutil.Child;

public class MyMain_초기화순서 {
	
	
	//상속객체에서 초기화 순서는 부모객체부터 처리
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
