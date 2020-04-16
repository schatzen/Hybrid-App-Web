import java.util.Scanner;

class 문제4 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1, su2;
		String op; //operator 연산자

		System.out.print("두 정수와 +,-,*,/ 중 하나를 입력하세요 (ex: 4 * 9 ) >> ");
		su1 = scan.nextInt();
		op = scan.next();
		su2 = scan.nextInt();
		

		double total;

		if(op.equals("+")) {
		total = su1 + su2;
		System.out.printf("계산 결과 : %d + %d = %f\n",su1,su2,total);
		} else if (op.equals("-")) {
		total = su1 - su2;
		System.out.printf("계산 결과 : %d - %d = %f\n",su1,su2,total);
		} else if (op.equals("*")) {
		total = su1 * su2;
		System.out.printf("계산 결과 : %d * %d = %f\n",su1,su2,total);
		} else if (op.equals("/")) {
			if(su2 == 0) {
			System.out.print("0으로 나눌 수 없습니다.\n");
			} else {
		total = su1 / (double)su2;
		System.out.printf("계산 결과 : %d / %d = %.2f\n",su1,su2,total);
		}
		}


	}
}
