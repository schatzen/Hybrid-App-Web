class Q_13
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("�����͸� �Է��ϼ��� �����÷���[Ctrl+Z]");
		
		int alpha_count = 0;
		int number_count=0;
		int white_count=0;
		int special_count=0;

		while(true){
            int ch = System.in.read();

			//Ctrl+Z ������ ���� (ch=-1)
			if(ch==-1) break;
             
            System.out.printf("%c",ch);
   
			if( (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') )
				alpha_count++;
			else if(ch>='0' && ch<='9')
				number_count++;
			else if(ch==' ' || ch=='\t' || ch=='\r' || ch=='\n')
				white_count++;
			else
				special_count++;
       
		}
		System.out.printf("���ĺ� ����: %d\n",alpha_count);
		System.out.printf("���� ����: %d\n",number_count);
		System.out.printf("ȭ��Ʈ ����: %d\n",white_count);
		System.out.printf("Ư�� ��ȣ: %d\n",special_count);
	}
}
