class Q_3
{
	public static void main(String[] args) throws Exception
	{
		//문자 1개 입력받기
		System.out.print("문자 1개을 입력하세요>>");
		int ch = System.in.read();
        //대문자냐?
        if(ch>='A' && ch<='Z')
			System.out.printf("대문자 [%c]\n",ch);
		//소문자냐?
        else if(ch>='a' && ch<='z')
			System.out.printf("소문자 [%c]\n",ch); 
		//숫자냐?
        else if(ch>='0' && ch<='9')
			System.out.printf("숫자 [%c]\n",ch); 
		//특수문자?
		else
			System.out.printf("특수문자 [%c]\n",ch); 



	}
}
