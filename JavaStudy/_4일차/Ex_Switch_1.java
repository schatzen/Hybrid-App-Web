import java.util.Scanner;

class Ex_Switch_1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        String fruit;
        String res="";

        System.out.print("���ϸ�:");
		fruit = scan.next();

		switch(fruit)
		{
			case "����": res="�޴�";     break;
			case "����": res="�ÿ��ϴ�"; break;
			case "����": res="���ִ�";   break;
			case "����": res="�˾Ƶ�";   break;
            default:     res="������?";
 		}

		System.out.printf("[%s]��(��) [%s]\n", fruit,res);







	}
}
