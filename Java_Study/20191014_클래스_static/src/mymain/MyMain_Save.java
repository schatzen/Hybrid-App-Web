package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {

		Save save1 = new Save("�ϱ뵿", 100000);
		Save save2 = new Save("�̱뵿", 200000);
		Save save3 = new Save("��뵿", 300000);

		// ���� ����
		Save.rate = 0.1; // Ŭ������. ������ = ��(static ���� ǥ��)

		System.out.println("---����:0.1---");
		save1.display();
		save2.display();
		save3.display();

		// ���� ����
		save1.rate = 0.2; // ������� ��ü�� ���ؼ��� ǥ�� save2.rate save3.rate ���x
							// ������ ��Ŭ���������� Save(Ŭ������).rate�� �ϴ� �� ����
							// ���: statoc way�� ǥ������ �ʾƼ�

		System.out.println("---����:0.2---");
		save1.display();
		save2.display();
		save3.display();
	}

}
