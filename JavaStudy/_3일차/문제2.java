import java.util.Scanner;

class ����2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int total_sec;
		System.out.print("��:");
		total_sec = scan.nextInt();

		int day;
		int hour;
		int minute;
		int sec;

		//�� ���ϱ�
		day = total_sec / (3600*24);
		total_sec = total_sec % (3600*24);

		//�ð� ���ϱ�
		hour  = total_sec / 3600;
		total_sec = total_sec % 3600;

		//�� ���ϱ�
        minute = total_sec / 60;

		//�� ���ϱ�
		sec = total_sec % 60;

		System.out.println("***�Ͻú���***");
		System.out.printf("%d�� %d�ð� %d�� %d��\n",
			               day,hour,minute,sec);







	}
}
