class Ex_While_1
{
	public static void main(String[] args) 
	{
		int n = 0;
		// for( ; n<3 ;  )
		while(n<3) // n =   0    1    2     3
		{            //    0<3  1<3  2<3   3<3
			         //     T    T    T     F
		   System.out.print("�ȳ�");
		   n++;//������
		}


        //n������ ��
		n = 10;
		int sum=0;
		int i=1;
		while(i<=n)// i =  1 2 3 4 ...  10
		{                           // 10<=10
           sum = sum + i;//������
		   i++;
		}

        System.out.println();//�ٹٲٱ�
		System.out.printf("\n%d������ ��=%d\n", n,sum);






	}
}
