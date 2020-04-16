package mymain;

import java.util.Scanner;

public class MyMain_2_Use����ó�� {

	static boolean isNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // '1'
			// ������ ���ڰ� �ƴϳ�?
			if (!(ch >= '0' && ch <= '9')) // = if(ch<'0' || ch > '9')

				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int su;

		while (true) {

			try {

				// �� �ڵ� ����
				System.out.print("���ڸ� �Է��ϼ��� : ");
				String str = scan.next().trim();
				
				
				//�Ƹ��� parseInt�޼ҵ� ������ �Ʒ��� ���� ���ܸ� ������.
				if (isNumber(str) == false)
					throw new NumberFormatException("���ڸ� ����϶��...");

				su = Integer.parseInt(str);

				// Exception
				// �� NumberFormatException
				System.out.printf("�Է��� ���� [%d] �Դϴ�. \n", su);

			} catch (Exception e) {
				 //e.printStackTrace(); // �߻��� ������ ���ο��� �����ش�.
				System.out.println(e.getMessage());

			}

		}

	}

}
