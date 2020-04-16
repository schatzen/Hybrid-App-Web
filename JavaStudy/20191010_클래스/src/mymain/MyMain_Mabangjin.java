package mymain;

import java.util.Scanner;

import myutil.Mabangjin;

public class MyMain_Mabangjin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int chasu;
		String yn="y";
		
		Mabangjin ma = new Mabangjin();
		
		
		while(true) {
			
			System.out.printf("차수:");
			chasu = scan.nextInt();
			if(chasu%2==0) {
				System.out.println("홀수만 입력하세요!!");
				continue;//현재명령종료하고 다음제어식으로 이동해라
			}
			//차수전달
			//ma.chasu = chasu;(X)
			ma.setChasu(chasu);
			
			//마방진 출력
			ma.display();
			
			
			//또할래?
			System.out.printf("그만할래?(y/n):");
			yn = scan.next();
			
			//if(yn.equals("y") || yn.equals("Y")) break;
			//대소문자 구분하지 않고 비교
			if(yn.equalsIgnoreCase("y"))break;
			
		}
		
		System.out.println("--End--");
		
		
		
		
	}

}
