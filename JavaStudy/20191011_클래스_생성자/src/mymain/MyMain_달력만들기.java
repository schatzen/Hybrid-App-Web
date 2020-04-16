package mymain;

import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_달력만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int year,month;
		String yn="y";
		//달력만드는 객체생성
		MyCalendar mc = new MyCalendar();
		
		while(true) {
			
			System.out.print("년도 월:");
			year  = scan.nextInt();
			month = scan.nextInt();
			
			//year,month설정
			mc.setDate(year, month);
			
			//달력출력
			mc.display();
			
			//또할래?
			System.out.print("또할래?(y/n):");
			yn = scan.next();
			//입력받은값이 y가아니면 끝내라(while 탈출해라)
			if(yn.equalsIgnoreCase("Y")==false)break;
			
		}
		
		System.out.println("--End--");
		

	}

}
