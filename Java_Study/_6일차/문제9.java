import java.util.Scanner;

class ����9 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int n;
		int total= 1;
		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		n = scan.nextInt();

		for(int i = 1; i<=n; i++)
		{
			total = total * i;
			
		}

		System.out.printf("%d! ==> %d\n",n,total);

	}
}
