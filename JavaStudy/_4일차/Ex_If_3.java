import java.util.Calendar;

class Ex_If_3
{
	public static void main(String[] args) 
	{
		int year=1980;
		int age;
		String tti="";


        //Design(����) Pattern(Singleton)
		//: ���Ű��߹���� ����ȭ�� ������ �����س��� 
		//  ���߹���� 
		
		//��¥����:���� �ý��� ��¥����(����Ͻú��ʹи���ũ)
		Calendar c  = Calendar.getInstance();
        
		int current_year = c.get(Calendar.YEAR); 
		//���� 1��:0  2��:1
        int current_month= c.get(Calendar.MONTH) + 1;
		int current_day  = c.get(Calendar.DATE);
        

		System.out.printf("������ %d�� %d�� %d��\n",
			              current_year,
			              current_month,
			              current_day);



		//���� ���ϱ�
		//       ����      - ����⵵ + 1  
		age = current_year - year     + 1;

		//�챸�ϱ�
        //   ����⵵%12 => 0~11 
		// 12��
		// 4  5  6  7  8  9  10 11 0  1  2  3  <= year%12
		// �� �� �� �� �� �� �� �� �� �� �� ��
        // �� �� �� �� �� �� �� �� �� �� �� ��

        if(year%12==0) tti="������";
		else if(year%12==1) tti="��";
		else if(year%12==2) tti="��";
		else if(year%12==3) tti="����";
		else if(year%12==4) tti="��";
		else if(year%12==5) tti="��";
		else if(year%12==6) tti="ȣ����";
		else if(year%12==7) tti="�䳢";
		else if(year%12==8) tti="��";
		else if(year%12==9) tti="��";
		else if(year%12==10) tti="��";
		else if(year%12==11) tti="��";

        System.out.printf("����⵵:%d\n",year);
        System.out.printf("����:%d(��)\n",age);
        System.out.printf("��:%s(��)\n",tti);






	}
}
