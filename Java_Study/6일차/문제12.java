import java.util.Scanner;

class ����12 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		double r;
		int n;
		double total = 1;
		

		System.out.print("�Ǽ��� �Է��ϼ���. >> ");
		r = scan.nextDouble();
		System.out.print("������ �Է��ϼ���. >> ");
		n = scan.nextInt();

		for (int i =1;i<=n;i++)
		{
			total = total * r;
		}

		System.out.printf("%.1f\n",total);
	}
}
