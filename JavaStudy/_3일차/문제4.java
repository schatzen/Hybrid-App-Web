
import java.util.Scanner;

class ����4
{
	/*
        //����->ȭ��
		F  = 9/5*C + 32 

		//ȭ��->����
		C  = 5/9*(F-32) 
	*/
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        double c;
		double f;   // f = 9/5*c + 32 

        System.out.print("�µ�(����):" );
		c = scan.nextDouble();

		f = 9.0/5.0 * c + 32.0;
        
		System.out.println("*** ��� ***");
		System.out.printf("���� %.1f���� ȭ�� %.1f�Դϴ�\n",c,f);



	}
}
