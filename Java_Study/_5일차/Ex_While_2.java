import java.io.FileReader;

class Ex_While_2
{
	public static void main(String[] args) throws Exception
	{
		//File�б� ��ü����
		FileReader  fr = new FileReader("Ex_While_2.java");
        
		int count = 0;//�ѹ��ڼ�
		int alpha_upper_count = 0;//�빮�� ����
		int alpha_lower_count = 0;//�ҹ��� ����
		int number_count = 0;//���ڰ���
        //white ���� :����(' ') ��(\t)  \r  \n
		int white_count = 0;

		while(true)
		{
			//fr�� ����Ű�� ���� 1�� �о����
			//������ġ�� �̵�
			int ch = fr.read();
							   
            if(ch==-1)//ȭ���� ���̸�(EOF:End Of File)
			   break;//����ݺ����� Ż���ض�

            count++;//���ڼ� ����
			//�빮�ڳ�?
			if(ch>='A' && ch<='Z') 
				alpha_upper_count++;
			else if(ch>='a' && ch<='z')//�ҹ��ڳ�?
				alpha_lower_count++;
            else if(ch>='0' && ch<='9')//���ڳ�?
			    number_count++;
            
			//white���� üũ
            if(ch==' ' || ch=='\t' || ch=='\r' || ch=='\n')
				white_count++;

			
			System.out.printf("%c",ch);//�о�¹��� ���

			//Thread.sleep(10);
		}

        //�ݱ�
		fr.close();

		//�ѹ��ڼ� ���
		System.out.printf("�ѹ��ڼ�:%d(��)\n", count);
		System.out.printf("�빮�ڼ�:%d(��)\n", alpha_upper_count);
		System.out.printf("�ҹ��ڼ�:%d(��)\n", alpha_lower_count);
		System.out.printf("���ڰ���:%d(��)\n", number_count);
		System.out.printf("ȭ��Ʈ���ڼ�:%d(��)\n", white_count);


	}
}
