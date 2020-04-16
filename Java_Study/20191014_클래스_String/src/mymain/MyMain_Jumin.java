package mymain;

import java.util.Scanner;

import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String jumin_no;
		String yn = "y";

		Jumin jumin = new Jumin();

		while (true) {
			System.out.print("주민번호(xxxxxx-xxxxxx):");
			jumin_no = scan.next();

			// 주민번호 넘기기
			jumin.setJumin_no(jumin_no);

			// 추출결과 출력
			int year = jumin.getYear();
			int age = jumin.getAge();
			String tti = jumin.getTti();
			String local = jumin.getLocal();
			String season = jumin.getSeason();
			String gender = jumin.getGender();
			String ganji = jumin.getGanji();
			Boolean isValid = jumin.isValid();

			System.out.printf("출생년도:%d년\n", year);
			System.out.printf("나이:%d(살)\n", age);
			System.out.printf("띠:%s(띠)\n", tti);
			System.out.printf("지역:%s\n", local);
			System.out.printf("계절:%s\n", season);
			System.out.printf("성별:%s\n", gender);
			System.out.printf("간지:%s(년)\n", ganji);
			System.out.println(isValid);

			// 또 할래?
			System.out.println("또 할래?(y/n) : ");
			yn = scan.next();

			// 입력값이 y가 아니면 끝내라
			if (!yn.equalsIgnoreCase("y"))
				break;

		}

		System.out.println("--END--");

	}

}