package mymain;

import java.util.Scanner;

import myutil.Snail;

public class MyMain_Snail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int row_count,col_count;
		String yn = "y";
		
		Snail snail = new Snail();
		
		
		while(true) {
			
			System.out.print("�� ������:");
			row_count = scan.nextInt();
			col_count = scan.nextInt();
			
			//�����̰�ü���� ��/������ �ѱ��
			snail.setData(row_count, col_count);
			//������ ���� ��� ���
			snail.display();
			
			System.out.print("���ҷ�(y/n):");
			yn = scan.next();
			
			//"y"�� �ƴϸ� ������...
			if(!yn.equalsIgnoreCase("y"))break;
		}
		
		System.out.println("--End--");
		
		
	}

}
