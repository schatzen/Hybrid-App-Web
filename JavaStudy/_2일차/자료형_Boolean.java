class 자료형_Boolean 
{
	public static void main(String[] args) 
	{
		//논리형 자료형 
		//상수   : true or false
		//출력서식: %b  or %B

        //출력메소드
		System.out.print("출력만");
		System.out.println();//줄바꾸기
		System.out.println("출력 + 줄바꾸기");
		System.out.printf("%b\n", 3 > 2 );
		System.out.printf("%B\n", 3 > 2 );

		// 변수(Variable)선언
		// 자료형  변수명;
		boolean   bOk;
		bOk = 3 > 2;
		System.out.println(bOk);
		bOk = 3 < 2;
		System.out.println(bOk);

		int a = 3, b = 2;//%d (decimail: 10진수출력서식)
		bOk =  a > b;
		//                             \n:new line(line feed)
		//                                줄바꾸기
		System.out.printf("%d > %d => %b\n", a,b,bOk);


        


	}
}
