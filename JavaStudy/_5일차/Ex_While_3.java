class Ex_While_3
{
	public static void main(String[] args) throws Exception
	{
		//Ű����κ��� �Է�
        System.out.println("�����Ϸ��� Ctrl+Z");
		int count=0;
		while(true)
		{
            //Ű���� ���ۿ��� 1byte�� �о����  
            int ch = System.in.read();
			//Ctrl+Zġ�� -1 ��ȯ
			if(ch==-1) break;

            count++;
			System.out.printf("%c",ch);
		}

		System.out.printf("�Է¹��ڼ�:%d\n",count);

		System.out.println("--End--");


	}
}
