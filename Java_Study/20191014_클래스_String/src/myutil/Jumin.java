package myutil;

import java.util.Calendar;

public class Jumin {

	private String jumin_no;

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	// �ֹι�ȣ
	/////////////// 01234567890123 < index
	// jumin_no = "901212-1234567";

	/*
	 * �ֹι�ȣ ���� <������> <�ܱ���> �� �� �� �� 1900 1 2 5 6 2000 3 4 7 8
	 */

	// ����⵵
	public int getYear() {

		// substring(����index, ����+����)
		String str_year = jumin_no.substring(0, 0 + 2); // "90"

		// String�� int�� ��ȯ��Ű�� API : Integer.parseInt("90") : 90
		int year = Integer.parseInt(str_year);// "90" -> 90

		// �������� ����
		char gender = jumin_no.charAt(7); // '1'
		if (gender == '1' || gender == '2' || gender == '5' || gender == '6')
			year = year + 1900;
		else
			year = year + 2000;

		return year;
	}

	public int getAge() {
		// ���� = ����⵵ - ����⵵ + 1
		Calendar cal = Calendar.getInstance();
		int age = cal.get(Calendar.YEAR) - this.getYear() + 1;

		return age;
	}

	public String getTti() {

		// �� ���ϱ� : ����⵵%12 > 0~11
		// 4 5 6 7 8 9 10 11 0 1 2 3
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// �� �� �� �� �� �� �� �� �� �� �� ��

		String[] tti_array = { "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��" };

		int tti_index = this.getYear() % 12;
		String tti = tti_array[tti_index];

		return tti;
	}

	// �ֹι�ȣ
	// 12345678901234 < index
	// jumin_no = 901212-1234567

	public String getLocal() {

		String str_local = jumin_no.substring(8, 10);
		int local = Integer.parseInt(str_local);

		if (local >= 0 && local <= 8)
			return "����";
		else if (local >= 10 && local <= 13)
			return "�λ�";
		else if (local >= 14 && local <= 24)
			return "���";
		else if (local >= 25 && local <= 47)
			return "����";
		else if (local >= 48 && local <= 66)
			return "����/����";
		else if (local >= 55 && local <= 58)
			return "����";
		else if (local >= 67 && local <= 70)
			return "�뱸";
		else if (local >= 71 && local <= 80)
			return "���";
		else
			return "�泲/����";

	}

	// �¾ ����
	public String getSeason() {
		String str_month = jumin_no.substring(2, 2 + 2);
		int month = Integer.parseInt(str_month);

		if (month == 1 || month == 2 || month == 12)
			return "�ܿ�";
		else if (month >= 3 && month <= 5)
			return "��";
		else if (month >= 6 && month <= 8)
			return "����";
		else
			return "����";

	}

	public String getGender() {
		char gender = jumin_no.charAt(7);

		if (gender == '1' || gender == '3' || gender == '5' || gender == '7')
			return "����";
		else
			return "����";

	}

	public String getGanji() {
		String[] gan_array = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
		String[] ji_array = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };

		String gan = gan_array[this.getYear() % 10];
		String ji = ji_array[this.getYear() % 12];

		return gan + ji;

	}

	// �ֹι�ȣ ��ȿ�� üũ

	public boolean isValid() {
		boolean isValid;

		String jumin = jumin_no.substring(0, 6) + jumin_no.substring(7, 13);

		int[] number = new int[12];
		int[] gob = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int number_gob;
		int number_gob_sum = 0;

		for (int i = 0; i <= 11; i++) {
			number[i] = Integer.parseInt(jumin.substring(i, i + 1));
			number_gob = number[i] * gob[i];
			number_gob_sum += number_gob;
		}

		if ((11 - (number_gob_sum % 11)) % 10 == Integer.parseInt(jumin_no.substring(13, 14))) {
			isValid = true;
		} else {
			isValid = false;
		}

		return isValid;

	}

}
