package mymain;

import java.util.Scanner;

public class MyMain_1_Not예외처리 {

	static boolean isNumber(String str) {
		//  str="a23";
		for(int i=0;i<str.length();i++) {//i = 0 1 2
			char ch = str.charAt(i);//'1'
			//숫자형문자가 아니냐?
			//if( !(ch >='0' && ch <'9') ) return false;
			if( ch <'0' || ch > '9' ) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int su;
		
		while(true) {
			System.out.print("숫자만 입력:");
			String str = scan.next().trim();
			if(isNumber(str)==false) {
				System.out.println("---숫자만 입력하세요---");
				continue;
			}
			su = Integer.parseInt(str);
				
				
			
			System.out.printf("입력한 수는 [%d]입니다\n",su);
			
		}
		
		
		
	}

}
