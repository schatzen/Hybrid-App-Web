class 대입연산자
{
	public static void main(String[] args) 
	{
		//복합대입연산자:  += -= *= /= %= &= ^= |=  >>= ...

		int n = 10;
        n++; // n = n + 1 

		n = n + 2; //  n += 2;

		n *= 2 ; // n = n * 2;
		
		n /= 2 ; // n = n / 2;


		//동일한 연산자 사용시
		n = 3 + 2 - 4 + 1 - 2; // left->right

		//동일한 연산자 : 단항연산자
		boolean bYes = !!!!!!!!!!!(3>2);// left<-right
		n = ~~~~~~~~n;
        int a,b,c;
		a = b = c = 0;


		//short circuit evaluation(경제적연산)
		a = 1;
		b = 2;
		boolean bRes;
		bRes = --a > 1 && ++b > 0 ;

		// a=0  b=2  bRes=false
		System.out.printf("a=%d b=%d bRes=%b\n", a, b,bRes);

		bRes = ++a >=1 || ++b > 0;
		// a=1  b=2  bRes=true
		System.out.printf("a=%d b=%d bRes=%b\n", a, b,bRes);





	}
}
