import java.util.Scanner;

class 문제2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        int total_sec;
		System.out.print("초:");
		total_sec = scan.nextInt();

		int day;
		int hour;
		int minute;
		int sec;

		//일 구하기
		day = total_sec / (3600*24);
		total_sec = total_sec % (3600*24);

		//시간 구하기
		hour  = total_sec / 3600;
		total_sec = total_sec % 3600;

		//분 구하기
        minute = total_sec / 60;

		//초 구하기
		sec = total_sec % 60;

		System.out.println("***일시분초***");
		System.out.printf("%d일 %d시간 %d분 %d초\n",
			               day,hour,minute,sec);







	}
}
