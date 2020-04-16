import java.util.Scanner;

class 문제2
{
	public static void main(String[] args) 
	{
		/*
		     [입력]
             주문(콜라:1000  커피:1500  쥬스:2000):콜라
			 수량:3
			 금액:10000
			 
			 [결과]
			 구입품목:콜라
			 총구입금액:3000
			 부가세(10%):300
			 잔액:6700
		*/
        Scanner scan = new Scanner(System.in);
		//입력에 필요한 변수
		String drink_name;
		int    drink_price;
		int    count;
		int    money;

		//출력에 필요한 변수
        int total_money; //총액 = 단가 * 수량;
		int tax; //부가세
        int remain_money;//잔액  


        System.out.println("====[입력]====");
		System.out.print("주문(콜라:1000 커피:1500 쥬스:2000):");
		drink_name = scan.next();
        System.out.print("수량:");
		count = scan.nextInt();
		System.out.print("금액:");
		money = scan.nextInt();

		//음료단가 구하기
        switch(drink_name)
		{
           case "콜라": drink_price = 1000;break;
           case "커피": drink_price = 1500;break;
           case "쥬스": drink_price = 2000;break;
		   default: drink_price = 0;
		}

        //결과 계산
		total_money = drink_price * count;//총액
		tax = (int)(total_money * 0.1);//부가세
		remain_money = money - (total_money+tax);

		System.out.println("====[결과]====");
		System.out.printf("구입품목:%s\n",drink_name);
		System.out.printf("총구입액:%d(원)\n",total_money);
		System.out.printf("부가세(10%%):%d(원)\n",tax);
		System.out.printf("거스름돈:%d(원)\n",remain_money);

        


		
	}
}
