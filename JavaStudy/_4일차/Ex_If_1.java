import java.util.Random;

class Ex_If_1
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
		else
		{
			// 10~19���̸�
			if(age>=10 && age< 20) 
				res = "û�ҳ�";
			else
			{
				// 21 ~ 39
				if(age>=20 && age< 40) 
					res = "����";
				else
				{
					// 40 ~69
					if(age>=40 && age< 70) 
						res = "���"; 
					else
					{
						// 70�̻�
						if(age >= 70) res = "���";
					}
				}
			}
		}

        System.out.printf("[%d]�� [%s]�Դϴ�\n", age,res);

	}
}
