class �ڷ���_������ 
{
	public static void main(String[] args) 
	{
		//����:�Ҽ����� ���¼�
		//������: byte short   int  long
		//                  (�⺻��)  
		//�������: 10  0  0L 10L(long�� ���) 
		//��¼���: %d  %o  %x
		//        %d(decimal) :10����
		//        %o(octal)   : 8����
		//        %x(hexa)    :16����  

		int n = 100;
		//n's���� �������� ���
		System.out.printf("10����=%d\n",n);
		System.out.printf(" 8����=0%o\n",n);
		System.out.printf("16����=0x%x\n",n);

		//�������� ���� 10������ ���
		System.out.printf("%d\n", 100);
		System.out.printf("%d\n", 0144);
		System.out.printf("%d\n", 0x64);

        //��¼����� ���� %md
		//      m:�����ü�ڸ���
		//      m<0 : left  align
		//      m>0 : right align 
		n = 123;
		System.out.printf("[%10d]\n", n); //right
		System.out.printf("[%010d]\n", n); //right
		System.out.printf("[%-10d]\n", n);//left
		//System.out.printf("[%-010d]\n", n);// error

        // Ȯ�����ڸ��� < ����ڸ��� => ����  
	    System.out.printf("[%2d]\n",n); 

		System.out.printf("[%32s]\n", 
			         Integer.toBinaryString(n));
	
	}
}
