package mymain;

import myutil.Save;

/*
   static ����/�޼ҵ�
   1.��������: ���α׷� ���۽�
   2.�����
       Ŭ������.������
       Ŭ������.�޼ҵ��
 */


public class MyMain_Save {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Save s1 = new Save("�ϱ浿", 1000000);
		Save s2 = new Save("�̱浿", 2000000);
		Save s3 = new Save("��浿", 3000000);
		
		//���� ����
		Save.rate = 0.1;// Ŭ������.������=��(static����ǥ��)
		
		System.out.println("--����:0.1--");
		s1.display();
		s2.display();
		s3.display();
		
		//���� ����
		s1.rate = 0.2;//(���:static way ǥ������ �ʾƼ�...)
		System.out.println("--����:0.2--");
		s1.display();
		s2.display();
		s3.display();
		
		
		
	}

}
