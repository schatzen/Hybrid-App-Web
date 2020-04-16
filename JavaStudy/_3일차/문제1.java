import java.util.Scanner;

class 문제1
{
	public static void main(String[] args) 
	{

        Scanner scan = new Scanner(System.in);
		int money;
		System.out.print("금액:");
		money = scan.nextInt();

		//각각의 현금권의 갯수를 저장할 변수
        int m_50000;
		int m_10000;
		int m_5000;
		int m_1000;

		int m_500;
		int m_100;
		int m_50;
		int m_10;

        //money = 123560;

		//50000권 갯수구하기
		m_50000 = money /  50000;
		money = money % 50000;// money=23560
		
		//10000권 갯수구하기
		m_10000 = money / 10000;
		money = money % 10000;
		
		//5000권 갯수구하기
        m_5000 = money / 5000;
		money = money % 5000;

        //1000권 갯수구하기
        m_1000 = money / 1000;
		money = money % 1000;

		//500 갯수구하기
        m_500 = money / 500;
		money = money % 500;

        //100 갯수구하기
        m_100 = money / 100;
		money = money % 100;

		//50 갯수구하기
        m_50 = money / 50;   //money = 60
		money = money % 50;   
       
        //10 갯수구하기
        m_10 = money / 10; 



		System.out.println("***권종별 갯수***");
		System.out.printf("50000원권:%d(매)\n", m_50000);
		System.out.printf("10000원권:%d(매)\n", m_10000);
		System.out.printf(" 5000원권:%d(매)\n", m_5000);
		System.out.printf(" 1000원권:%d(매)\n", m_1000);
		System.out.printf("  500원권:%d(개)\n", m_500);
		System.out.printf("  100원권:%d(개)\n", m_100);
		System.out.printf("   50원권:%d(개)\n", m_50);
		System.out.printf("   10원권:%d(개)\n", m_10);




		
	}
}
