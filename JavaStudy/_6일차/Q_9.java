class Q_9
{
	public static void main(String[] args) 
	{
		int n = 5;
		int sum = 1;
        
		//Factorial ���
		// n! = n * (n-1) * (n-2) * .....
		for(int i=n;i>0;i--){
           //System.out.println(i + " ");
		   sum = sum * i;
		}

		//������
        System.out.printf("%d!=%d\n",n,sum);
        
	}
}
