package mymain;

import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_�޷¸���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int year,month;
		String yn="y";
		//�޷¸���� ��ü����
		MyCalendar mc = new MyCalendar();
		
		while(true) {
			
			System.out.print("�⵵ ��:");
			year  = scan.nextInt();
			month = scan.nextInt();
			
			//year,month����
			mc.setDate(year, month);
			
			//�޷����
			mc.display();
			
			//���ҷ�?
			System.out.print("���ҷ�?(y/n):");
			yn = scan.next();
			//�Է¹������� y���ƴϸ� ������(while Ż���ض�)
			if(yn.equalsIgnoreCase("Y")==false)break;
			
		}
		
		System.out.println("--End--");
		

	}

}
