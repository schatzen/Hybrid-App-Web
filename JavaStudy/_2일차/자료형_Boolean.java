class �ڷ���_Boolean 
{
	public static void main(String[] args) 
	{
		//���� �ڷ��� 
		//���   : true or false
		//��¼���: %b  or %B

        //��¸޼ҵ�
		System.out.print("��¸�");
		System.out.println();//�ٹٲٱ�
		System.out.println("��� + �ٹٲٱ�");
		System.out.printf("%b\n", 3 > 2 );
		System.out.printf("%B\n", 3 > 2 );

		// ����(Variable)����
		// �ڷ���  ������;
		boolean   bOk;
		bOk = 3 > 2;
		System.out.println(bOk);
		bOk = 3 < 2;
		System.out.println(bOk);

		int a = 3, b = 2;//%d (decimail: 10������¼���)
		bOk =  a > b;
		//                             \n:new line(line feed)
		//                                �ٹٲٱ�
		System.out.printf("%d > %d => %b\n", a,b,bOk);


        


	}
}
