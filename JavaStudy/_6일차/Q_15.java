class Q_15
{
	public static void main(String[] args) 
	{
		int n = 1;
		int sign=-1;
		while(n<20){
           System.out.printf("%d",n*sign);
		   if(n<19)
			   System.out.print(',');

		   n+=2;
		   sign = -sign;
		}

		System.out.println();
	}
}
