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
			
			System.out.print("�ֹι�ȣ(xxxxxx-xxxxxxx):");
			jumin_no = scan.next();
			
			//�ֹι�ȣ �ѱ��
			jumin.setJumin_no(jumin_no);
			
			//������ ���
			
			if(jumin.isValid()==false) {
				System.out.println("--Ʋ�� �ֹι�ȣ�Դϴ�--");
				continue;
			}
			
			int year = jumin.getYear();
			int age  = jumin.getAge();
			String gender = jumin.getGender();
		    String ganji = jumin.getGanji();
		    String season = jumin.getSeason();
			
			System.out.printf("����⵵:%d(%s)\n",year,ganji);
			System.out.printf("����:%d(��)\n",age);
			System.out.printf("����:%s\n",gender);
			System.out.printf("����:%s\n",season);
			
			
			//���ҷ�?
			System.out.print("�� �ҷ�?(y/n):");
			yn = scan.next();
					
			// �Է°��� y�� �ƴϸ� ������
			if(!yn.equalsIgnoreCase("Y"))break;
		}
		
		System.out.println("--End--");
		
		
	}

}
