import java.util.Scanner;

class ����2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1,su2,su3;

		System.out.print("���� �� ���� �Է��Ͻÿ� : ");
		su1 = scan.nextInt();
		su2 = scan.nextInt();
		su3 = scan.nextInt();

		System.out.printf("��: %d %d %d\n",su1,su2,su3);



		if(su1 < su2 && su1 < su3) {
		System.out.printf("�� �� ���� ���� ��: %d\n",su1);
		} else if (su2 < su1 && su2 < su3) {
		System.out.printf("�� �� ���� ���� ��: %d\n",su2);
		} else if (su3 < su1 && su3 < su2) {
		System.out.printf("�� �� ���� ���� ��: %d\n",su3);
		}


	}
}
