class Ex_Method3
{
	public static void main(String[] args) 
	{
		MyMath2 mm2 = new MyMath2();
        int n = -15;
		int res = mm2.abs(n);
		System.out.printf("|%d|=%d\n",n,res);
         
	    n = 10;
	    double result = mm2.factorial(n);
	    System.out.printf("%d!=%.0f\n", n,result);
	    
		
		mm2.sosu(20);
		
		

	}
}
