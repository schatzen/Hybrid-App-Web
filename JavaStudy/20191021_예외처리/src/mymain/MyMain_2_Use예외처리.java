package mymain;

import java.util.Scanner;

public class MyMain_2_Use����ó�� {

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
			
			try
			{
				//���ڵ� ����
				System.out.print("���ڸ� �Է�:");
				String str = scan.next().trim();
				
				//�Ƹ��� parseInt�޼ҵ� ������ �Ʒ��� ���� ������ ������...
				//if(isNumber(str)==false)
				//	throw new NumberFormatException("���ڸ� ����϶��..");
				
				su = Integer.parseInt(str);
				// Exception
				//  ��NumberFormatException
				System.out.printf("�Է��� ���� [%d]�Դϴ�\n",su);
				
			} catch(Exception e) { //Exception e  = new NumberFormatException();
				//e.printStackTrace();
				//System.out.println(e.getMessage());
				System.out.println("--���ڸ� �Է��ϼ���--");
			}
			
			
		}
		
		
		
	}

}
