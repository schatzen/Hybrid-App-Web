
/*
	�����: �̸� �����س��� ���(��Ī)
	�ĺ���(identifier): ������,Ŭ������,�޼ҵ��,�����...

*/

class ���� 
{
	//����Ŭ���� : ����$Inner.class
	class Inner
	{

	}

	public static void main(String[] args) 
	{
		System.out.println("--[�ĺ��� ���� ���ǻ���]--");
		System.out.println("--1.���ڷ� �����ϸ� �ȵȴ�");
		//			int	1kor;(X)	int kor1(O)
		System.out.println("--2.�߰��� ���� ���� �ȵȴ�");
		//			int kor 1;(X)
		System.out.println("--3.Ư������ ��� ���Ѵ�(��	_$ ����)");
		System.out.println("--	(Ű���忡�� ���� ���ĺ� �ѱ��� ������ ����)");
		//	int bonus%;(X)	int ___;(O) <=�������̸� ��¡�� �ο�
		//	int kor_1;(O)	int $$$;(O)

		System.out.println("--4.������ �����Ѵ�");
		// int public;(X)

		System.out.println("--[Ŭ������ ����(�ǰ�)]--");
		System.out.println("--1.�빮�ڷ� ����");
		System.out.println("--2.2���� �̻��� �ܾ ���յǸ� �Ŵܾ� ù���ڴ� �빮��");
		System.out.println("--3.2���� �̻��� �ܾ ���յǸ� �Ŵܾ� ù���ڴ� �빮�� + ������_��");
		
		//	2.MyProfile : My + Profile
		//	2.MyProfileSchool : My + Profile + School
		//	3.My_Profile
		//	3.My_Profile_School

		System.out.println("--[������/�żҵ�� ����(�ǰ�)]--");
		System.out.println("--1.�ҹ��ڷ� ����");
		System.out.println("--2.2���� �̻��� �ܾ ���յǸ� �Ŵܾ� ù���ڴ� �빮��");
		System.out.println("--3.2���� �̻��� �ܾ� ������ _���ض�");
		//����
		int myMoney; //My + Money
		int my_money;
		int my_Money;

		int mymoney; //�Ǳ��ϴµ� ����
		int my_save_year_money; //�ǰ�	

        System.out.println("--[��� ����(�ǰ�)]--");
		System.out.println("--1.�빮�ڷ� ����");
		System.out.println("--2.2���� �̻��� �ܾ� ������ _ ���ض�");

        //���(���� ������ �� ���� ��)  
		final double PI = 3.14;
		final String MY_PROJECT_NAME = "NAMING_TEST";
		//PI = 3.141592; (X)
        //����(���� ������ �� �ִ� ��)
		       double d  = 3.14;
		d = 3.141592;//����...




	}

	public int two_su_hap(int a,int b){
			return a + b;
	}
}
