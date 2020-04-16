package mymain;

public class MyMain_배열활용 {

	public static void main(String[] args) {
		// ##활용1
		// 31 28 31 30 31 30 31 31 30 31 30 31

		int month = 10;
		int[] month_array = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int last_day = month_array[month - 1];

		System.out.printf("%d월은 %d일까지 있습니다.\n", month, last_day);

		// ##활용2
		int year = 2020;

		// 띠 구하기 : 출생년도%12 => 0~11
		// 4 5 6 7 8 9 10 11 0 1 2 3
		// 자 축 인 묘 진 사 오 미 신 유 술 해
		// 쥐 소 범 토끼 용 뱀 말 양 원숭이 닭 개 돼지

		String[] tti_array = { "원숭이", "닭", "개", "돼지", "쥐", "소", "범", "토끼", "용", "뱀", "말", "양" };
		String tti = tti_array[year % 12];

		System.out.printf("%d년도의 띠는 %s띠 입니다.\n", year, tti);

		// ##활용3 : 10간 12지

		// 올해 > 2019

		// 10간 : 년도 % 10 => 1~9
		// 4 5 6 7 8 9 0 1 2 3
		// 갑 을 병 정 무 기 경 신 임 계

		String[] gan_array = { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" };

		// 12지
		// 4 5 6 7 8 9 10 11 0 1 2 3
		// 자 축 인 묘 진 사 오 미 신 유 술 해

		String[] ji_array = { "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" };
		String ganji = gan_array[year % 10] + ji_array[year % 12];

		System.out.printf("%d년은 %s년 입니다.\n", year, ganji);

	}

}
