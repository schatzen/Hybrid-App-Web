package mymain;

import java.util.Scanner;

import myutil.Mabangjin;

public class MyMain_Mabangjin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int chasu;
		String yn="y";
		
		Mabangjin ma = new Mabangjin();
		
		
		while(true) {
			
			System.out.printf("����:");
			chasu = scan.nextInt();
			if(chasu%2==0) {
				System.out.println("Ȧ���� �Է��ϼ���!!");
				continue;//�����������ϰ� ������������� �̵��ض�
			}
			//��������
			//ma.chasu = chasu;(X)
			ma.setChasu(chasu);
			
			//������ ���
			ma.display();
			
			
			//���ҷ�?
			System.out.printf("�׸��ҷ�?(y/n):");
			yn = scan.next();
			
			//if(yn.equals("y") || yn.equals("Y")) break;
			//��ҹ��� �������� �ʰ� ��
			if(yn.equalsIgnoreCase("y"))break;
			
		}
		
		System.out.println("--End--");
		
		
		
		
	}

}
