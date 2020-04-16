class Q_11
{
	public static void main(String[] args) 
	{
		/*
           4     4     4     4     4 
		 + -  -  -  +  -  -  -  +  - 
		   1     3     5     7     9   ....

        i =1     3     5     7     9 
		*/
        double pi=0;
		int    sign=1;

		for(int i=1;i<100000000;i+=2){
            if(sign>0)
			   pi = pi + (4.0 / i); 
			else
			   pi = pi - (4.0 / i); 
            
			// pi = pi + sign*(4.0 / i); 
            
			sign = -sign;//부호변경 + <-> -
		}
		System.out.println(pi);

	}
}
