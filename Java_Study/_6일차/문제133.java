class ����133 
{
	public static void main(String[] args) throws Exception
	{
		     

		int count = 0;
		int alpha_count = 0;
		int number_count = 0;
		int white_count = 0 ;
		int etc_count = 0;

		System.out.printf("�����͸� �Է��ϼ���. �������� 'Ctrl + Z' �� ��������.\n");
		
		while(true) {

		int ch = System.in.read();
		if(ch == -1)
		break;

		if((ch >= 65 && ch<= 90) || (ch>=97 && ch<=122)) 
			alpha_count++;
		 else if(ch >= '0' && ch <= '9') 
			number_count++;
		 else if(ch==' ' || ch=='\r' || ch=='\n' || ch=='\t') 
			white_count++;
		 else 
			etc_count++;

		}

		System.out.printf("����  : %d(��)\n",number_count);
		System.out.printf("���ĺ� ���� : %d(��)\n",alpha_count);
		System.out.printf("ȭ��Ʈ ���� : %d(��)\n",white_count);
		System.out.printf("Ư���� ���� : %d(��)\n",etc_count);
	}
}
