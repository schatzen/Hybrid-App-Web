import java.util.Scanner;

class ����1
{
	public static void main(String[] args) 
	{

        Scanner scan = new Scanner(System.in);
		int money;
		System.out.print("�ݾ�:");
		money = scan.nextInt();

		//������ ���ݱ��� ������ ������ ����
        int m_50000;
		int m_10000;
		int m_5000;
		int m_1000;

		int m_500;
		int m_100;
		int m_50;
		int m_10;

        //money = 123560;

		//50000�� �������ϱ�
		m_50000 = money /  50000;
		money = money % 50000;// money=23560
		
		//10000�� �������ϱ�
		m_10000 = money / 10000;
		money = money % 10000;
		
		//5000�� �������ϱ�
        m_5000 = money / 5000;
		money = money % 5000;

        //1000�� �������ϱ�
        m_1000 = money / 1000;
		money = money % 1000;

		//500 �������ϱ�
        m_500 = money / 500;
		money = money % 500;

        //100 �������ϱ�
        m_100 = money / 100;
		money = money % 100;

		//50 �������ϱ�
        m_50 = money / 50;   //money = 60
		money = money % 50;   
       
        //10 �������ϱ�
        m_10 = money / 10; 



		System.out.println("***������ ����***");
		System.out.printf("50000����:%d(��)\n", m_50000);
		System.out.printf("10000����:%d(��)\n", m_10000);
		System.out.printf(" 5000����:%d(��)\n", m_5000);
		System.out.printf(" 1000����:%d(��)\n", m_1000);
		System.out.printf("  500����:%d(��)\n", m_500);
		System.out.printf("  100����:%d(��)\n", m_100);
		System.out.printf("   50����:%d(��)\n", m_50);
		System.out.printf("   10����:%d(��)\n", m_10);




		
	}
}
