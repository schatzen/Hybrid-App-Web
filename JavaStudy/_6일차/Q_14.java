class Q_14
{
	public static void main(String[] args) 
	{
		double res=0;
		int n = 1;
		while(n<10){
            System.out.printf("1.0/%d",n);
			if(n<9)
				System.out.print(" + ");
            
			res = res + 1.0/n;
            n+=2;
		}
		System.out.printf("=%.10f\n",res);
	}
}
