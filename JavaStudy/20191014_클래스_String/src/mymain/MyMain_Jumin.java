package mymain;

import java.util.Scanner;

import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String jumin_no;
		String yn="y";
		
		Jumin jumin = new Jumin();
		
		while(true) {
			
			System.out.print("주민번호(xxxxxx-xxxxxxx):");
			jumin_no = scan.next();
			
			//주민번호 넘기기
			jumin.setJumin_no(jumin_no);
			
			//추출결과 출력
			
			if(jumin.isValid()==false) {
				System.out.println("--틀린 주민번호입니다--");
				continue;
			}
			
			int year = jumin.getYear();
			int age  = jumin.getAge();
			String gender = jumin.getGender();
		    String ganji = jumin.getGanji();
		    String season = jumin.getSeason();
			
			System.out.printf("출생년도:%d(%s)\n",year,ganji);
			System.out.printf("나이:%d(살)\n",age);
			System.out.printf("성별:%s\n",gender);
			System.out.printf("계절:%s\n",season);
			
			
			//또할래?
			System.out.print("또 할래?(y/n):");
			yn = scan.next();
					
			// 입력값이 y가 아니면 끝내라
			if(!yn.equalsIgnoreCase("Y"))break;
		}
		
		System.out.println("--End--");
		
		
	}

}
