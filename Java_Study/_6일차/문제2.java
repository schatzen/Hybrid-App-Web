import java.util.Scanner;

class 문제2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1,su2,su3;

		System.out.print("숫자 세 개를 입력하시오 : ");
		su1 = scan.nextInt();
		su2 = scan.nextInt();
		su3 = scan.nextInt();

		System.out.printf("수: %d %d %d\n",su1,su2,su3);



		if(su1 < su2 && su1 < su3) {
		System.out.printf("셋 중 가장 작은 수: %d\n",su1);
		} else if (su2 < su1 && su2 < su3) {
		System.out.printf("셋 중 가장 작은 수: %d\n",su2);
		} else if (su3 < su1 && su3 < su2) {
		System.out.printf("셋 중 가장 작은 수: %d\n",su3);
		}


	}
}
