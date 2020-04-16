import java.util.Scanner;

class Ex_Switch_22
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int kor;
		String grade="";
		System.out.print("국어:");
		kor = scan.nextInt();

        //점수의 유효성 체크
		if(kor>=0 && kor<=100)// 0~100사이면
		{
			// switch(수식활용)
			switch(kor/5)
			{			
				case 20:
				case 19: grade="A+";break;
				case 18: grade="A";break;
				
				case 17: grade="B+";break;
				case 16: grade="B";break;

				case 15: grade="C+";break;
				case 14: grade="C";break;

				case 13: grade="D+";break;
				case 12: grade="D";break;

				default: grade="F";
			}
			System.out.printf("[%d]점 등급:%s\n", kor,grade);
		}
		else
		{
            System.out.printf("[%d] 점수가 유효하지 않습니다\n",kor);    
		}
	}
}
