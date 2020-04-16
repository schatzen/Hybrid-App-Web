class 문제6 
{
	public static void main(String[] args) 

	{

		System.out.println();
		System.out.println("정상가격            세일가격");
		System.out.println("----------------------------");
		

		for(int normal = 10000;normal<=20000;normal+=1000)
		{
			double sale;
			sale = normal*0.7;

			System.out.printf("%d                %.1f\n",normal,sale);
		}



	}
}
