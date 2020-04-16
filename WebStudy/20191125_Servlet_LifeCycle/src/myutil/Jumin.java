package myutil;

import java.util.Calendar;

public class Jumin /* extends Object */ {

	private String jumin_no;
	String [] tti_array = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
	

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}
	
	//�ֹι�ȣ
	//            01234567890123  <= index  
	//jumin_no = "901212-1234567";
	
	
	/*
	 �ֹι�ȣ ����
	             ������     �ܱ���  
	             ��  ��     ��  �� 
	  1900       1   2      5   6   
	  2000       3   4      7   8 
	  
	 */
	
	
	//����⵵
	public int getYear() {
		//  substring(����index, ����+����);
		String str_year = jumin_no.substring(0,0+2);//"90"
		//String -> int�� ��ȯ: Integer.parseInt("90")->90
		int year = Integer.parseInt(str_year);//"90"=> 90
		
		//�������� ����
		char gender = jumin_no.charAt(7);// '1'
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			year = year + 1900;
		else
			year = year + 2000;
		
		return year;
	}
	
	
	//���� ���ϱ�
	public int getAge() {
		
		// ���� = ����⵵ - ����⵵ + 1
		// ���س⵵ ���ؼ� 2019��� �־�ߵȴ�
		Calendar c = Calendar.getInstance();
		//          ����⵵  
		int age= c.get(Calendar.YEAR) - this.getYear() + 1;
				
		return age;
	}
	
	
	
	public String getTti() {
		
		//�챸�ϱ� :  ����⵵%12 => 0~11 <= tti_index
		// 4  5  6  7  8  9  10 11 0  1  2  3 <=����⵵%12 
		// �� �� �� �� �� �� �� �� �� �� �� ��
		// �� �� �� �� �� �� �� �� �� �� �� ��
		int tti_index = this.getYear()%12;
		
		return tti_array[tti_index];
	}

	//�ֹι�ȣ
	//            01234567890123  <= index  
	//jumin_no = "901212-1234567";	
	public String getLocal() {
		
		String str_local = jumin_no.substring(8, 8+2);
		//String->int
		int local_code = Integer.parseInt(str_local);
		if(local_code>=0 && local_code<=8) return "����";
		else if(local_code>=9 && local_code<=12) return "�λ�";
		else if(local_code>=13 && local_code<=15) return "��õ";
		else if(local_code>=16 && local_code<=25) return "��⵵";
		else if(local_code>=26 && local_code<=34) return "������";
		else if(local_code>=35 && local_code<=39) return "��û�ϵ�";
		else if(local_code==40) return "����";
		else if(local_code>=41 && local_code<=47) return "��û����";
		else if(local_code==44 || local_code==49) return "������";
		else if(local_code>=48 && local_code<=54) return "����ϵ�";
		else if(local_code>=55 && local_code<=56) return "����";
		else if(local_code>=57 && local_code<=64) return "���󳲵�";
		else if(local_code>=70 && local_code<=75
				|| local_code>=77 && local_code<=81
		          ) return "���ϵ�";
		else if(local_code>=82 && local_code<=84
				|| local_code>=86 && local_code<=92
		          ) return "���ϵ�";
		else if(local_code==85) return "���";
		else if(local_code>=93 && local_code<=95) return "���ϵ�";
		
		return "��Ÿ";
	}
	
	//�¾ ����
	public String getSeason() {
		String str_month = jumin_no.substring(2, 2+2);
		int    month = Integer.parseInt(str_month);//"12"->12
		
		switch(month/3)
		{
			case 1: return "��";   // 3  4  5
			case 2: return "����"; // 6  7  8 
			case 3: return "����"; // 9 10 11
		}
		
		return "�ܿ�";
	}
	
	//����
    public String getGender() {
    
    	char gender = jumin_no.charAt(7);
    	if(gender=='1' || gender=='3' || gender=='5' || gender=='7')
    		return "����";
    	
    	return "����";
    }
  
    
    
    //60����(10��12��)
    public String getGanji() {
        //                0 1 2 3 4 5 6 7 8 9      <=gan_index
    	String gan_str = "����Ӱ谩����������";
    	//                0 1 2 3 4 5 6 7 8 9 1011 <=ji_index
    	String ji_str  = "�������������ι��������";
    	
    	int gan_index = this.getYear()%10;//0~9
    	int ji_index  = this.getYear()%12;//0~11
    	
    	char gan = gan_str.charAt(gan_index);
    	char ji  = ji_str.charAt(ji_index);
    	
    	return String.format("%c%c��", gan,ji);
    }
    
    //�ֹι�ȣ ��ȿ��
    public boolean isValid() {
    	// 01234567890123
    	// 801212-1234560
    	// 2345670892345
    	
    	int []  check = {2,3,4,5,6,7,0,8,9,2,3,4,5};
    	
    	//���ڿ�=>���� : Integer.parseInt("1")
    	//����  =>���� : '1' - '0'
    	//               49  - 48 => 1 
    	//               '0' : 48  '1' : 49  '2' : 50
    	int sum = 0 ;
    	
    	for(int i=0;i<=12;i++) {
    		sum = sum + (jumin_no.charAt(i)-'0')*check[i];
    	}
    	//�������
    	int result_no = (11-(sum%11))%10;
    	    	
    	//�ֹι�ȣ ������ ����
    	int last_no = jumin_no.charAt(13) - '0';
    	
    	//System.out.println(result_no);
    	
    	return (result_no==last_no);
    }
	
}




