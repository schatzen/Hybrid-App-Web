class 문제8 
{
	public static void main(String[] args) 
	{
		System.out.println();
		System.out.println("  n                  1부터 n까지의 합");
		System.out.println("--------------------------------------");

		int sum = 0;

		for(int i=1;i<=5;i++)
		{
		 sum = sum + i;
		 System.out.printf("  %d                   %2d\n",i,sum);
		}
	}
}
