package mymain;

import java.util.Scanner;

import myutil.Mabangjin;

public class MyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Mabangjin ma = new Mabangjin();

		int chasu;
		String yn = "y";

		while (true) {

			System.out.printf("���� : ");
			chasu = scan.nextInt();

			if (chasu % 2 == 0) {
				System.out.println("Ȧ���� �Ԏ��ϼ���");
			}

			// ��������
			ma.setChasu(chasu);

			// ������ ���
			ma.display();

			// �� �ҷ�?
			System.out.printf("�׸��ҷ�? (y/n)");
			yn = scan.next();

			// if(yn.equals("y")||yn.equals("Y")) break;
			if (yn.equalsIgnoreCase("y"))
				break; // :��ҹ��� ������ �ʴ� API

		}

		System.out.println("��End��"); // break�� ������ ������ �� ���� �ڵ��� ���� ��.

	}
}
