import java.util.Scanner;

class Ex_For_5
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int dan;
		System.out.print("��?:");
		dan = scan.nextInt();

		//��ȿ��üũ(��ȿ���� ������ ������)
		//if( ! (dan>=2 && dan<=9) ){
        if( dan < 2 || dan > 9){
           System.out.println("dan�� 2~9���̰��� �Է��ϼ���!!");
           return;// main method�� ���� ����� ��ȯ(����)
		}

		//�ǹٸ����� ������
		for(int i=1;i<=9;i++){ // i = 1 2 3 4 ... 9
			System.out.printf("%d x %d = %2d\n", 
				               dan,  i , dan*i);
		}






	}
}
