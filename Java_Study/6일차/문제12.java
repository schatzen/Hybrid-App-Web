import java.util.Scanner;

class 문제12 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		double r;
		int n;
		double total = 1;
		

		System.out.print("실수를 입력하세요. >> ");
		r = scan.nextDouble();
		System.out.print("정수를 입력하세요. >> ");
		n = scan.nextInt();

		for (int i =1;i<=n;i++)
		{
			total = total * r;
		}

		System.out.printf("%.1f\n",total);
	}
}
