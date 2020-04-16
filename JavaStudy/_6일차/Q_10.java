class Q_10
{
	public static void main(String[] args) 
	{
		int sum = 1;
		int n=10;
		for(int i=1;i<=n;i++){
           if(i%2==0)
			   sum = sum * i;
		}

		System.out.printf("1ºÎÅÍ %d±îÁö Â¦¼öÀÇ °ö : %s\n",n,sum);
	}
}
