import java.util.Scanner;

class Q_12
{
	public static void main(String[] args) 
	{
		double r;
		int    n;
		Scanner scan = new Scanner(System.in);
		System.out.print("실수를 입력하세요>>");
		r = scan.nextDouble();
		System.out.print("정수를 입력하세요>>");
		n = scan.nextInt();

        // r's n승 계산
		double sum = 1;
		for(int i=0;i<n;i++){
           sum = sum * r;
		}

		System.out.println(sum);

		//Java API
		System.out.println( Math.pow(r,n) );

	}
}
