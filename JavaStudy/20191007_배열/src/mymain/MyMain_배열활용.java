package mymain;

public class MyMain_�迭Ȱ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//##Ȱ��1
		//  1  2  3  4  5  6  7  8  9  10 11 12 <= month
	    //  0  1  2  3  4  5  6  7  8  9  10 11 <= index(÷��)
		//  31 28 31 30 31 30 31 31 30 31 30 31
		
		int month = 12;
		//                     0  1  2  3 ...
		int [] month_array = {31,28,31,30,31,30,31,31,30,31,30,31};
		int last_day = month_array[month-1];
		
		/*
		switch(month) 
	    {
		  case  4: 
		  case  6: 
		  case  9: 
		  case 11: last_day=30;break;
		  case  2: last_day=28;break;
		  default: last_day= 31;
		}
		*/
		
		System.out.printf("[%d]���� [%d]�ϱ���...\n",month,last_day);
		
		//##Ȱ��2
		int year = 2020;
		String tti="";
		//�챸�ϱ� : ����⵵%12=> 0~11
		
		// 4  5  6  7  8  9  10 11 0  1  2  3 
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// �� �� �� �� �� �� �� �� �� �� �� ��
		//                         0      1   2     3  
		String [] tti_array = {"������","��","��","����",
				//              4    5      6       7  
				               "��","��","ȣ����","�䳢",
                //              8    9   10   11      				               
				               "��","��","��","��"};
		tti = tti_array[ year%12 ];
		/*
		switch(year%12)
		{
		   case 0: tti="������";break;
		   case 1: tti="��";break;
		   case 2: tti="��";break;
		}
		*/
		
		System.out.printf("[%d]��� [%s]��\n",year,tti);
		//����=>2019
		
		//##Ȱ��3 : 10�� 12��
		
		// 10�� : �⵵%10=> 0 ~ 9          
		// 4  5  6  7  8  9  0  1  2  3
		// �� �� �� �� �� �� �� �� �� ��
		//                      0     1   2    3    4 
		String [] gan_array = {"��","��","��","��","��",
				               "��","��","��","��","��"};
		
				// 12�� : �⵵%12=> 0 ~ 11
		// 4  5  6  7  8  9  10 11 0  1  2  3  
		// �� �� �� �� �� �� �� �� �� �� �� ��
		String [] ji_array = {"��","��","��","��",
							  "��","��","��","��",
							  "��","��","��","��"};
		
		String ganji = gan_array[year%10] + ji_array[year%12];
		
		System.out.printf("[%d]�� [%s��]\n",year,ganji);
		
		
		
	}

}
