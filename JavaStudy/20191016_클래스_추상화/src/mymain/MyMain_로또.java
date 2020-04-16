package mymain;

import java.util.Scanner;

import myutil.Lotto;

public class MyMain_로또 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int [] user_no = new int[6];
		String yn = "y";
		
		Lotto lotto = new Lotto();
		
		//번호 추첨
		lotto.make_win_no();
		
		while(true) {
		   System.out.print("숫자 6개을 입력:");
		   
		   /*
		      for(int i=0;i<user_no.length;i++)
		        user_no[i] = scan.nextInt();  
		   */
		   user_no[0] = scan.nextInt();
		   user_no[1] = scan.nextInt();
		   user_no[2] = scan.nextInt();
		   user_no[3] = scan.nextInt();
		   user_no[4] = scan.nextInt();
		   user_no[5] = scan.nextInt();
		   
		   //입력번호 전달
		   lotto.setUser_no(user_no);
		   
		   //추첨결과 출력
		   lotto.display();
		   
		   //또할래?
		   System.out.print("또 할래?(y/n):");
		   yn = scan.next();
		   
		   if(!yn.equalsIgnoreCase("y"))break;
		
		}
		
		System.out.println("--End--");

	}

}
