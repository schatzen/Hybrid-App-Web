import java.util.Scanner;

class ����4 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1, su2;
		String op; //operator ������

		System.out.print("�� ������ +,-,*,/ �� �ϳ��� �Է��ϼ��� (ex: 4 * 9 ) >> ");
		su1 = scan.nextInt();
		op = scan.next();
		su2 = scan.nextInt();
		

		double total;

		if(op.equals("+")) {
		total = su1 + su2;
		System.out.printf("��� ��� : %d + %d = %f\n",su1,su2,total);
		} else if (op.equals("-")) {
		total = su1 - su2;
		System.out.printf("��� ��� : %d - %d = %f\n",su1,su2,total);
		} else if (op.equals("*")) {
		total = su1 * su2;
		System.out.printf("��� ��� : %d * %d = %f\n",su1,su2,total);
		} else if (op.equals("/")) {
			if(su2 == 0) {
			System.out.print("0���� ���� �� �����ϴ�.\n");
			} else {
		total = su1 / (double)su2;
		System.out.printf("��� ��� : %d / %d = %.2f\n",su1,su2,total);
		}
		}


	}
}
