class 산술연산자
{
	public static void main(String[] args) 
	{
		//산술연산자: 
		//  *  /(몫)  %(나머지)
		//  +  -
       
	    int a= 10,b=3,res;

		res = a + b;
		System.out.printf("%d + %d = %d\n", a, b, res);
		
		res = a - b;
		System.out.printf("%d - %d = %d\n", a, b, res);

        res = a * b;
		System.out.printf("%d * %d = %d\n", a, b, res);

        res = a / b; //몫  
		System.out.printf("%d / %d = %d\n", a, b, res);

		res = a % b; //나머지
		//                 \10\ % 3 = "1"  
		// %->문자로 인식시켜려면 : %%=> '%'
		// "->문자로 인식시키려면 : \"=> '"'
		// \->문자로 인식시키려면 : \\=> '\'
		System.out.printf("\\%d\\ %% %d = \"%d\"\n", a, b, res);

        // 몫: 정수/정수     
		//     실수/실수<=몫+나머지 => (int)연산결과 
        System.out.printf("10.0/3=%d\n", (int)(10.0/3) );

		// 나머지:  피젯수 % 젯수  
		//          피젯수 < 젯수 => 피젯수
		System.out.printf("3 %% 10 =%d\n", 3 % 10);

        System.out.printf("10.0 %% 3.0 =%.0f\n", 10.0 % 3.0);


        //난수(무작위)발생객체  
		//방법1)  꼭대기(위)  import java.util.Random;
		//방법2)
		java.util.Random rand = new java.util.Random();
        //       rand.nextInt(n) : 0 ~ n-1 난수발생  
        int su = rand.nextInt(11);

        //짝수/홀수
		if( su%2==0 )
			System.out.printf("%d는 짝수\n",su);//짝수
		else
			System.out.printf("%d는 홀수\n",su);//홀수

        //3의배수냐?
        if( su%3==0 )  
            System.out.printf("%d는 3의 배수\n",su);    






	}
}
