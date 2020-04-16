class 문제10 
{
	public static void main(String[] args) 
	{

		int total= 1;

		for(int i = 2; i<=10; i+=2) {			
			total = total * i;
		}

		System.out.printf(" 1부터 10까지의 짝수의 곱 ==> %d\n",total);
	}
}
