class 자료형_문자형 
{
	public static void main(String[] args) 
	{
		//문자형: char (2byte)
		//상수  : 'A'  '가'  '韓'
        //출력서식: %c

		// ASCII :0 ~ 127 (표준통신문자)
		// 0~31  : 통신 및 제어문자
		// 32~   : 일반문자
		//         'A': 65  <- 32 ->  'a': 97
		//         '0': 48  '1': 49
		//         ' ': 32

        System.out.printf("%c\n", 'A');
        System.out.printf("%c%c\n", 65,66);
        System.out.printf("%c\n", '가');
		System.out.printf("%d\n", (int)'가');
		System.out.printf("%c\n", 44032);

		System.out.printf("%c\r\n", 'X'); 


        //제어문자
		// \r  : carrige returun    (HOME)
		// \n  : line feed(new line)(ENTER)
		// \t  : tab
		// \b  : left arrow <-

		System.out.println("A\tB\tC");
		System.out.println("ABC\b\bX");
		
	    char ch;
		ch = '한';
		System.out.printf("[%c] code : %x\n", ch , (int)ch);
		System.out.printf("0xd55c : %c\n", 0xd55c);



	}
}
