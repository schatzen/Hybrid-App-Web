class Ex_If_2
{
	public static void main(String[] args) 
	{
		int su = 12;

        // 2,3의 배수냐?  if(2배수 && 3배수)
		if( su%2==0 && su%3==0 )
		{
			System.out.printf("[%d]은(는) 2의배수\n", su); //1
			System.out.printf("[%d]은(는) 3의배수\n", su); //2 
		}
        else
			System.out.println("조건에 맞지 않습니다");    //3
 
	}
}
