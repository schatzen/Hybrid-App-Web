package mymain;

public class MyMain_�迭Ȱ�� {

	public static void main(String[] args) {
		// ##Ȱ��1
		// 31 28 31 30 31 30 31 31 30 31 30 31

		int month = 10;
		int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int last_day = month_array[month - 1];

		System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�.\n", month, last_day);

		// ##Ȱ��2
		int year = 2020;

		// �� ���ϱ� : ����⵵%12 => 0~11
		// 4 5 6 7 8 9 10 11 0 1 2 3
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// �� �� �� �䳢 �� �� �� �� ������ �� �� ����

		String[] tti_array = { "������", "��", "��", "����", "��", "��", "��", "�䳢", "��", "��", "��", "��" };
		String tti = tti_array[year % 12];

		System.out.printf("%d�⵵�� ��� %s�� �Դϴ�.\n", year, tti);

		// ##Ȱ��3 : 10�� 12��

		// ���� > 2019

		// 10�� : �⵵ % 10 => 1~9
		// 4 5 6 7 8 9 0 1 2 3
		// �� �� �� �� �� �� �� �� �� ��

		String[] gan_array = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };

		// 12��
		// 4 5 6 7 8 9 10 11 0 1 2 3
		// �� �� �� �� �� �� �� �� �� �� �� ��

		String[] ji_array = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
		String ganji = gan_array[year % 10] + ji_array[year % 12];

		System.out.printf("%d���� %s�� �Դϴ�.\n", year, ganji);

	}

}
