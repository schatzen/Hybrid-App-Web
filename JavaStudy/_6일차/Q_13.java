class Q_13
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("데이터를 입력하세요 끝내시려면[Ctrl+Z]");
		
		int alpha_count = 0;
		int number_count=0;
		int white_count=0;
		int special_count=0;

		while(true){
            int ch = System.in.read();

			//Ctrl+Z 누르면 종료 (ch=-1)
			if(ch==-1) break;
             
            System.out.printf("%c",ch);
   
			if( (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') )
				alpha_count++;
			else if(ch>='0' && ch<='9')
				number_count++;
			else if(ch==' ' || ch=='\t' || ch=='\r' || ch=='\n')
				white_count++;
			else
				special_count++;
       
		}
		System.out.printf("알파벳 문자: %d\n",alpha_count);
		System.out.printf("숫자 문자: %d\n",number_count);
		System.out.printf("화이트 문자: %d\n",white_count);
		System.out.printf("특수 기호: %d\n",special_count);
	}
}
