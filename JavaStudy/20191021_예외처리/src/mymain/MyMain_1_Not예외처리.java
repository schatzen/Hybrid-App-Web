package mymain;

import java.util.Scanner;

public class MyMain_1_Not����ó�� {

	static boolean isNumber(String str) {
		//  str="a23";
		for(int i=0;i<str.length();i++) {//i = 0 1 2
			char ch = str.charAt(i);//'1'
			//���������ڰ� �ƴϳ�?
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
			System.out.print("���ڸ� �Է�:");
			String str = scan.next().trim();
			if(isNumber(str)==false) {
				System.out.println("---���ڸ� �Է��ϼ���---");
				continue;
			}
			su = Integer.parseInt(str);
				
				
			
			System.out.printf("�Է��� ���� [%d]�Դϴ�\n",su);
			
		}
		
		
		
	}

}
