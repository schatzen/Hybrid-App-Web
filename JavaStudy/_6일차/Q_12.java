import java.util.Scanner;

class Q_12
{
	public static void main(String[] args) 
	{
		double r;
		int    n;
		Scanner scan = new Scanner(System.in);
		System.out.print("�Ǽ��� �Է��ϼ���>>");
		r = scan.nextDouble();
		System.out.print("������ �Է��ϼ���>>");
		n = scan.nextInt();

        // r's n�� ���
		double sum = 1;
		for(int i=0;i<n;i++){
           sum = sum * r;
		}

		System.out.println(sum);

		//Java API
		System.out.println( Math.pow(r,n) );

	}
}
