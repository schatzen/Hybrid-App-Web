import java.io.FileReader;

class ����13_ 
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader("����13.java");

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

		System.out.printf("����  : %d(��)\n",number_count);
		System.out.printf("���ĺ� ���� : %d(��)\n",alpha_count);
		System.out.printf("ȭ��Ʈ ���� : %d(��)\n",white_count);
		System.out.printf("Ư���� ���� : %d(��)\n",etc_count);
	
		
		

	}
}
