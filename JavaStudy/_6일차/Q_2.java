import java.util.Scanner;

class Q_2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int su1,su2,su3;
        int min_val;//���������� 
 
		System.out.print("������ ������ �Է��ϼ���>>");
		su1 = scan.nextInt();
		su2 = scan.nextInt();
		su3 = scan.nextInt();

		System.out.printf("��: %d %d %d\n",su1,su2,su3);

        //���������� ���ϱ�( if��� �Ǵ� 3�׿����ڻ��) 
		if(su1>su2) 
			min_val = su2;
		else
			min_val = su1;

		if(min_val > su3)
			min_val = su3;

		System.out.printf("���� ������: %d\n",min_val);


	}
}
