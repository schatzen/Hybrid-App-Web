import java.util.Random;

class Ex_If_11
{
	public static void main(String[] args) 
	{
		Random rand = new Random();

		int age = 20;

        age = rand.nextInt(100) + 1; 

        String res="";
        //�Ƶ�   : 10�̸�
        //û�ҳ� : 10~19
		//����   : 20~39
		//���   : 40~69
		//���   : 70~

		if(age < 10)
			res = "�Ƶ�";
		else if(age>=10 && age< 20) // 10~19���̸�
			res = "û�ҳ�";
		else if(age>=20 && age< 40) // 21 ~ 39
			res = "����";
		else if(age>=40 && age< 70) // 40 ~69
			res = "���"; 
		else if(age >= 70) res = "���";// 70�̻�


        System.out.printf("[%d]�� [%s]�Դϴ�\n", age,res);
		
	}
}
