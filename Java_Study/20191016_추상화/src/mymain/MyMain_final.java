package mymain;

public class MyMain_final {
	
	/*
	 * final 
	 * 1.���� : final �ڷ��� ������ = ��;
	 * 				(�������)
	 * 2.�޼ҵ� : final �ڷ��� �޼ҵ��()
	 * 			(���̻� ������ ���� ���ƶ�)
	 * 
	 * 3.Ŭ���� : final class Ŭ������
	 * 			(������� ���ƶ�)
	 */
	

	final static String PROGRAM_NAME = "final ����";

	public static void main(String[] args) {

		System.out.println(MyMain_final.PROGRAM_NAME);
		
		//MyMain_final.PROGRAM_NAME = "���� final"; �̷������� ���� ���� X
		// can not be assigned : ����X

	}

}
