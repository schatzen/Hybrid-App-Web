class Q_8
{
	public static void main(String[] args) 
	{
		int n = 5;
		System.out.println("n    1���� n������ ��");
		System.out.println("======================");

		for(int i=1;i<=n;i++){
 
            //i������ ���ϱ�
			int sum=0;
            for(int k=0;k<=i;k++){
			   sum =  sum + k;  	
			}
            
            System.out.printf("%d\t%d\n",i,sum);

		}
	}
}
