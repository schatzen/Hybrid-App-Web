class Ex_If_2
{
	public static void main(String[] args) 
	{
		int su = 12;

        // 2,3�� �����?  if(2��� && 3���)
		if( su%2==0 && su%3==0 )
		{
			System.out.printf("[%d]��(��) 2�ǹ��\n", su); //1
			System.out.printf("[%d]��(��) 3�ǹ��\n", su); //2 
		}
        else
			System.out.println("���ǿ� ���� �ʽ��ϴ�");    //3
 
	}
}
