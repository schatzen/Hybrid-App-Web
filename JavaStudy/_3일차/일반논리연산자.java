class 일반논리연산자
{
	public static void main(String[] args) 
	{
		//일반논리연산자 : &&   ||
		//  &&  : 모두참이어야 참
		//  ||  : 둘중 1개만 참이면 참
        System.out.println("---- And ----");   
        System.out.printf("true  && true : %b\n"   ,true && true);
        System.out.printf("true  && false : %b\n"  ,true && false);
        System.out.printf("false && true : %b\n"  ,false && true);
        System.out.printf("false && false : %b\n" ,false && false);
        
		System.out.println("---- Or ----");   
        System.out.printf("true  || true : %b\n"   ,true || true);
        System.out.printf("true  || false : %b\n"  ,true || false);
        System.out.printf("false || true : %b\n"  ,false || true);
        System.out.printf("false || false : %b\n" ,false || false);


        //윤년 구하기
		//조건1) 400년의 배수인 년도 : year%400==0
		//조건2) 4의배수(조건1)면서 100의배수가 아닌년도(조건2)
		//            (year%4==0)   &&   (year%100 !=0) 
		int year = 2020;

		//if( (조건1) || (조건2) )윤년;

		if( 
			(year%400==0)/*조건1*/ 
			||
			(year%4==0 && year%100 !=0)/*조건2*/ 
		)
			System.out.printf("%d년도는 윤년\n",year);
		else
			System.out.printf("%d년도는 평년\n",year);


        //평점구하기
		int kor = 90;
		String grade = "F";

		//A 조건 :90 ~ 100 사이
		if(kor>=90 && kor<=100)
			grade="A";

		//B 조건 : 80 ~ 89
		if(kor>=80 && kor < 90)
			grade="B";

        //C 조건 : 70 ~ 79
		if(kor>=70 && kor < 80)
			grade="C";

		//D 조건 : 60 ~ 69
		if(kor>=60 && kor < 70)
			grade="D";

  
        System.out.printf("점수: %d(점) 등급:%s\n", kor,grade);   












	}
}
