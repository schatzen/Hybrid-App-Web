class �Ϲݳ�������
{
	public static void main(String[] args) 
	{
		//�Ϲݳ������� : &&   ||
		//  &&  : ������̾�� ��
		//  ||  : ���� 1���� ���̸� ��
        System.out.println("---- And ----");   
        System.out.printf("true  && true : %b\n"   ,true && true);
        System.out.printf("true  && false : %b\n"  ,true && false);
        System.out.printf("false && true : %b\n"  ,false && true);
        System.out.printf("false && false : %b\n" ,false && false);
        
		System.out.println("---- Or ----");   
        System.out.printf("true  || true : %b\n"   ,true || true);
        System.out.printf("true  || false : %b\n"  ,true || false);
        System.out.printf("false || true : %b\n"  ,false || true);
        System.out.printf("false || false : %b\n" ,false || false);


        //���� ���ϱ�
		//����1) 400���� ����� �⵵ : year%400==0
		//����2) 4�ǹ��(����1)�鼭 100�ǹ���� �ƴѳ⵵(����2)
		//            (year%4==0)   &&   (year%100 !=0) 
		int year = 2020;

		//if( (����1) || (����2) )����;

		if( 
			(year%400==0)/*����1*/ 
			||
			(year%4==0 && year%100 !=0)/*����2*/ 
		)
			System.out.printf("%d�⵵�� ����\n",year);
		else
			System.out.printf("%d�⵵�� ���\n",year);


        //�������ϱ�
		int kor = 90;
		String grade = "F";

		//A ���� :90 ~ 100 ����
		if(kor>=90 && kor<=100)
			grade="A";

		//B ���� : 80 ~ 89
		if(kor>=80 && kor < 90)
			grade="B";

        //C ���� : 70 ~ 79
		if(kor>=70 && kor < 80)
			grade="C";

		//D ���� : 60 ~ 69
		if(kor>=60 && kor < 70)
			grade="D";

  
        System.out.printf("����: %d(��) ���:%s\n", kor,grade);   












	}
}
