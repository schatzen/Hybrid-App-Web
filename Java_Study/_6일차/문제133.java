class 문제133 
{
	public static void main(String[] args) throws Exception
	{
		     

		int count = 0;
		int alpha_count = 0;
		int number_count = 0;
		int white_count = 0 ;
		int etc_count = 0;

		System.out.printf("데이터를 입력하세요. 끝내려면 'Ctrl + Z' 를 누르세요.\n");
		
		while(true) {

		int ch = System.in.read();
		if(ch == -1)
		break;

		if((ch >= 65 && ch<= 90) || (ch>=97 && ch<=122)) 
			alpha_count++;
		 else if(ch >= '0' && ch <= '9') 
			number_count++;
		 else if(ch==' ' || ch=='\r' || ch=='\n' || ch=='\t') 
			white_count++;
		 else 
			etc_count++;

		}

		System.out.printf("숫자  : %d(개)\n",number_count);
		System.out.printf("알파벳 문자 : %d(개)\n",alpha_count);
		System.out.printf("화이트 문자 : %d(개)\n",white_count);
		System.out.printf("특수한 문자 : %d(개)\n",etc_count);
	}
}
