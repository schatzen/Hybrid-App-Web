class ���������
{
	public static void main(String[] args) 
	{
		//���������: 
		//  *  /(��)  %(������)
		//  +  -
       
	    int a= 10,b=3,res;

		res = a + b;
		System.out.printf("%d + %d = %d\n", a, b, res);
		
		res = a - b;
		System.out.printf("%d - %d = %d\n", a, b, res);

        res = a * b;
		System.out.printf("%d * %d = %d\n", a, b, res);

        res = a / b; //��  
		System.out.printf("%d / %d = %d\n", a, b, res);

		res = a % b; //������
		//                 \10\ % 3 = "1"  
		// %->���ڷ� �νĽ��ѷ��� : %%=> '%'
		// "->���ڷ� �νĽ�Ű���� : \"=> '"'
		// \->���ڷ� �νĽ�Ű���� : \\=> '\'
		System.out.printf("\\%d\\ %% %d = \"%d\"\n", a, b, res);

        // ��: ����/����     
		//     �Ǽ�/�Ǽ�<=��+������ => (int)������ 
        System.out.printf("10.0/3=%d\n", (int)(10.0/3) );

		// ������:  ������ % ����  
		//          ������ < ���� => ������
		System.out.printf("3 %% 10 =%d\n", 3 % 10);

        System.out.printf("10.0 %% 3.0 =%.0f\n", 10.0 % 3.0);


        //����(������)�߻���ü  
		//���1)  �����(��)  import java.util.Random;
		//���2)
		java.util.Random rand = new java.util.Random();
        //       rand.nextInt(n) : 0 ~ n-1 �����߻�  
        int su = rand.nextInt(11);

        //¦��/Ȧ��
		if( su%2==0 )
			System.out.printf("%d�� ¦��\n",su);//¦��
		else
			System.out.printf("%d�� Ȧ��\n",su);//Ȧ��

        //3�ǹ����?
        if( su%3==0 )  
            System.out.printf("%d�� 3�� ���\n",su);    






	}
}
