package myutil;

import java.util.Calendar;

public class Jumin {

	private String jumin_no;

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	// 주민번호
	/////////////// 01234567890123 < index
	// jumin_no = "901212-1234567";

	/*
	 * 주민번호 성별 <내국인> <외국인> 남 여 남 여 1900 1 2 5 6 2000 3 4 7 8
	 */

	// 출생년도
	public int getYear() {

		// substring(시작index, 시작+개수)
		String str_year = jumin_no.substring(0, 0 + 2); // "90"

		// String을 int로 변환시키는 API : Integer.parseInt("90") : 90
		int year = Integer.parseInt(str_year);// "90" -> 90

		// 성별정보 추출
		char gender = jumin_no.charAt(7); // '1'
		if (gender == '1' || gender == '2' || gender == '5' || gender == '6')
			year = year + 1900;
		else
			year = year + 2000;

		return year;
	}

	public int getAge() {
		// 나이 = 현재년도 - 출생년도 + 1
		Calendar cal = Calendar.getInstance();
		int age = cal.get(Calendar.YEAR) - this.getYear() + 1;

		return age;
	}

	public String getTti() {

		// 띠 구하기 : 출생년도%12 > 0~11
		// 4 5 6 7 8 9 10 11 0 1 2 3
		// 자 축 인 묘 진 사 오 미 신 유 술 해
		// 쥐 소 범 토 용 뱀 말 양 원 닭 개 돼

		String[] tti_array = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };

		int tti_index = this.getYear() % 12;
		String tti = tti_array[tti_index];

		return tti;
	}

	// 주민번호
	// 12345678901234 < index
	// jumin_no = 901212-1234567

	public String getLocal() {

		String str_local = jumin_no.substring(8, 10);
		int local = Integer.parseInt(str_local);

		if (local >= 0 && local <= 8)
			return "서울";
		else if (local >= 10 && local <= 13)
			return "부산";
		else if (local >= 14 && local <= 24)
			return "경기";
		else if (local >= 25 && local <= 47)
			return "강원";
		else if (local >= 48 && local <= 66)
			return "전남/전북";
		else if (local >= 55 && local <= 58)
			return "광주";
		else if (local >= 67 && local <= 70)
			return "대구";
		else if (local >= 71 && local <= 80)
			return "경북";
		else
			return "경남/제주";

	}

	// 태어난 계절
	public String getSeason() {
		String str_month = jumin_no.substring(2, 2 + 2);
		int month = Integer.parseInt(str_month);

		if (month == 1 || month == 2 || month == 12)
			return "겨울";
		else if (month >= 3 && month <= 5)
			return "봄";
		else if (month >= 6 && month <= 8)
			return "여름";
		else
			return "가을";

	}

	public String getGender() {
		char gender = jumin_no.charAt(7);

		if (gender == '1' || gender == '3' || gender == '5' || gender == '7')
			return "남자";
		else
			return "여자";

	}

	public String getGanji() {
		String[] gan_array = { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" };
		String[] ji_array = { "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" };

		String gan = gan_array[this.getYear() % 10];
		String ji = ji_array[this.getYear() % 12];

		return gan + ji;

	}

	// 주민번호 유효성 체크

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
