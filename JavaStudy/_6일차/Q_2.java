import java.util.Scanner;

class Q_2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1,su2,su3;
        int min_val;//가장작은수 
 
		System.out.print("세개의 정수를 입력하세요>>");
		su1 = scan.nextInt();
		su2 = scan.nextInt();
		su3 = scan.nextInt();

		System.out.printf("수: %d %d %d\n",su1,su2,su3);

        //가장작은수 구하기( if사용 또는 3항연산자사용) 
		if(su1>su2) 
			min_val = su2;
		else
			min_val = su1;

		if(min_val > su3)
			min_val = su3;

		System.out.printf("가장 작은수: %d\n",min_val);


	}
}
