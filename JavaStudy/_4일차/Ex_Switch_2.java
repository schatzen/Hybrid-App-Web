import java.util.Scanner;

class Ex_Switch_2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int kor;
		String grade="";
		System.out.print("����:");
		kor = scan.nextInt();

        //������ ��ȿ�� üũ
		if(kor>=0 && kor<=100)// 0~100���̸�
		{
			// switch(����Ȱ��)
			switch(kor/10)
			{			

				case 10:
				case  9: grade="A";break;
				case  8: grade="B";break;
				case  7: grade="C";break;
				case  6: grade="D";break;
				default: grade="F";
			}
			System.out.printf("[%d]�� ���:%s\n", kor,grade);
		}
		else
		{
            System.out.printf("[%d] ������ ��ȿ���� �ʽ��ϴ�\n",kor);    
		}



	}
}
