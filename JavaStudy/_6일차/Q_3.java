class Q_3
{
	public static void main(String[] args) throws Exception
	{
		//���� 1�� �Է¹ޱ�
		System.out.print("���� 1���� �Է��ϼ���>>");
		int ch = System.in.read();
        //�빮�ڳ�?
        if(ch>='A' && ch<='Z')
			System.out.printf("�빮�� [%c]\n",ch);
		//�ҹ��ڳ�?
        else if(ch>='a' && ch<='z')
			System.out.printf("�ҹ��� [%c]\n",ch); 
		//���ڳ�?
        else if(ch>='0' && ch<='9')
			System.out.printf("���� [%c]\n",ch); 
		//Ư������?
		else
			System.out.printf("Ư������ [%c]\n",ch); 



	}
}
