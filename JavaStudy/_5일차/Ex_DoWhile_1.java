import java.util.Scanner;

class Ex_DoWhile_1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String yn="y";//���ҷ�?
        int dan;
		
		do{
			System.out.print("��?:");
			dan = scan.nextInt();

            //�ȵǴ� ����
			if(dan<2 || dan > 9){
                System.out.println("2~9���̰��� �Է��ϼ���");
				//�ݺ������� ���� ����� �����ϰ� 
				//���� ��������� �̵��ض�
				continue;
			}

			System.out.printf("==[%d]��==\n",dan);
			for(int i=1;i<=9;i++){
               System.out.printf("%d x %d = %2d\n",dan,i,dan*i);
			}

			//������ ������ ���� Ȯ��			
			System.out.print("���ҷ�?(y/n):");
			yn = scan.next();// yn="y" or yn="Y"
            //���ڿ� �񱳴� equals()����ؾ� �ȴ� 
		}while(yn.equals("y") || yn.equals("Y") );

		System.out.println("--End--");
	}
}
