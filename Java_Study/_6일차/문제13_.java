import java.io.FileReader;

class 문제13_ 
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("문제13.java");

		int count = 0;
		int alpha_count = 0;
		int number_count = 0;
		int white_count = 0 ;
		int etc_count = 0;

		while(true) {

		int ch = fr.read();
		
		count ++;


		if(ch >= 65 && ch<= 90) {
			alpha_count++;
		} else if(ch >= '0' && ch <= '9') {
			number_count++;
		} else if(ch==' ' || ch=='\r' || ch=='\n' || ch=='\t') {
			white_count++;
		} else {
			etc_count++;
		}

		if(ch == -1)
			break; 

		System.out.printf("%c",ch);
		Thread.sleep(1);
		}

		System.out.printf("숫자  : %d(개)\n",number_count);
		System.out.printf("알파벳 문자 : %d(개)\n",alpha_count);
		System.out.printf("화이트 문자 : %d(개)\n",white_count);
		System.out.printf("특수한 문자 : %d(개)\n",etc_count);
	
		
		

	}
}
