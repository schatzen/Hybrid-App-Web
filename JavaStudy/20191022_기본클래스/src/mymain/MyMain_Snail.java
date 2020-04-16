package mymain;

import java.util.Scanner;

import myutil.Snail;

public class MyMain_Snail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int row_count,col_count;
		String yn = "y";
		
		Snail snail = new Snail();
		
		
		while(true) {
			
			System.out.print("행 열갯수:");
			row_count = scan.nextInt();
			col_count = scan.nextInt();
			
			//달팽이객체에게 행/열갯수 넘기기
			snail.setData(row_count, col_count);
			//달팽이 생성 결과 출력
			snail.display();
			
			System.out.print("또할래(y/n):");
			yn = scan.next();
			
			//"y"가 아니면 끝내라...
			if(!yn.equalsIgnoreCase("y"))break;
		}
		
		System.out.println("--End--");
		
		
	}

}
