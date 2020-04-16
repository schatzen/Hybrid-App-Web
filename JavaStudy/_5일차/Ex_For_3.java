class Ex_For_3
{
	public static void main(String[] args) 
	{
		int n = 10;
		int sum = 0;
		//방법1
        for(int i=0;i<=n;i++) // i = 0 1 2 3 4 5 6 7 8 9 10
		{
            if(i%2==0)   //짝수면 누적해라
               sum = sum + i; //sum += i;
		}
		System.out.printf("%d까지의 수의 짝수의 합:%d\n", n,sum);
		//방법2
		sum = 0;
		for(int i=0;i<=n ;  i=i+2 /* i+=2 */) // i= 0 2 4 6 8 10
		{
           sum = sum + i;
		}
		System.out.printf("%d까지의 수의 짝수의 합:%d\n", n,sum);


	}
}
