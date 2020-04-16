import java.io.FileReader;

class Ex_While_2
{
	public static void main(String[] args) throws Exception
	{
		//File읽기 객체생성
		FileReader  fr = new FileReader("Ex_While_2.java");
        
		int count = 0;//총문자수
		int alpha_upper_count = 0;//대문자 갯수
		int alpha_lower_count = 0;//소문자 갯수
		int number_count = 0;//숫자갯수
        //white 문자 :공백(' ') 탭(\t)  \r  \n
		int white_count = 0;

		while(true)
		{
			//fr이 가리키는 문자 1개 읽어오기
			//다음위치로 이동
			int ch = fr.read();
							   
            if(ch==-1)//화일의 끝이면(EOF:End Of File)
			   break;//현재반복문을 탈출해라

            count++;//문자수 누적
			//대문자냐?
			if(ch>='A' && ch<='Z') 
				alpha_upper_count++;
			else if(ch>='a' && ch<='z')//소문자냐?
				alpha_lower_count++;
            else if(ch>='0' && ch<='9')//숫자냐?
			    number_count++;
            
			//white문자 체크
            if(ch==' ' || ch=='\t' || ch=='\r' || ch=='\n')
				white_count++;

			
			System.out.printf("%c",ch);//읽어온문자 출력

			//Thread.sleep(10);
		}

        //닫기
		fr.close();

		//총문자수 출력
		System.out.printf("총문자수:%d(개)\n", count);
		System.out.printf("대문자수:%d(개)\n", alpha_upper_count);
		System.out.printf("소문자수:%d(개)\n", alpha_lower_count);
		System.out.printf("숫자갯수:%d(개)\n", number_count);
		System.out.printf("화이트문자수:%d(개)\n", white_count);


	}
}
