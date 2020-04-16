import java.util.Random;

class Ex_If_1
{
	public static void main(String[] args) 
	{
		Random rand = new Random();

		int age = 20;

        age = rand.nextInt(100) + 1; 

        String res="";
        //아동   : 10미만
        //청소년 : 10~19
		//성년   : 20~39
		//장년   : 40~69
		//노년   : 70~

		if(age < 10)
			res = "아동";
		else
		{
			// 10~19사이면
			if(age>=10 && age< 20) 
				res = "청소년";
			else
			{
				// 21 ~ 39
				if(age>=20 && age< 40) 
					res = "성년";
				else
				{
					// 40 ~69
					if(age>=40 && age< 70) 
						res = "장년"; 
					else
					{
						// 70이상
						if(age >= 70) res = "노년";
					}
				}
			}
		}

        System.out.printf("[%d]살 [%s]입니다\n", age,res);

	}
}
