class 삼항연산자
{
	public static void main(String[] args) 
	{
		//삼항연산자:
		//  (조건) ? 값1 : 값2 
		//           (T)   (F)

        int a = 10, b= 5, c;
		//2수중 큰수구하기
		c = ( a > b ) ? a : b;

		System.out.printf("%d과(와) %d중 큰수는 %d\n",a,b,c);

		//절대값 구하기
		int m = -100, res;
        res = (m < 0) ? -m : m ;

		System.out.printf("|%d| = %d\n", m,res);



	}
}
