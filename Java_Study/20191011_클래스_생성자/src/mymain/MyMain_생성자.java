package mymain;

import myutil.MyDate;

public class MyMain_������ {

	public static void main(String[] args) {

		// ��ü����
		MyDate md = new MyDate();

		md.display();

		MyDate md2 = new MyDate(2019, 2, 2);
		md2.display();

		MyDate md3 = new MyDate(2000);
		md3.display();
		
		MyDate md4 = new MyDate(2000,11);
		md4.display();

	}

}
