class Ex_For_2
{
	//Ex_For_2.java:8: error: unreported exception InterruptedException; must be caught or declared to be thrown
	public static void main(String[] args) throws Exception
	{
		int sum = 0;//i값을 누적시킬변수
		int n = 50;
		for(int i=0; i<=n ;i++) // i = 0 1 2 ... 9 10
		{
            System.out.print(i);   
            if(i<n)
               System.out.print('+');   
			else
               System.out.print('=');   

            //i값 누적
            sum = sum + i; //  

			//1초 대기
			//Thread.sleep(100);// milisec : 1/1000초
		}
		System.out.println(sum);
	}
}
