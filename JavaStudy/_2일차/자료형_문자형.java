class �ڷ���_������ 
{
	public static void main(String[] args) 
	{
		//������: char (2byte)
		//���  : 'A'  '��'  '��'
        //��¼���: %c

		// ASCII :0 ~ 127 (ǥ����Ź���)
		// 0~31  : ��� �� �����
		// 32~   : �Ϲݹ���
		//         'A': 65  <- 32 ->  'a': 97
		//         '0': 48  '1': 49
		//         ' ': 32

        System.out.printf("%c\n", 'A');
        System.out.printf("%c%c\n", 65,66);
        System.out.printf("%c\n", '��');
		System.out.printf("%d\n", (int)'��');
		System.out.printf("%c\n", 44032);

		System.out.printf("%c\r\n", 'X'); 


        //�����
		// \r  : carrige returun    (HOME)
		// \n  : line feed(new line)(ENTER)
		// \t  : tab
		// \b  : left arrow <-

		System.out.println("A\tB\tC");
		System.out.println("ABC\b\bX");
		
	    char ch;
		ch = '��';
		System.out.printf("[%c] code : %x\n", ch , (int)ch);
		System.out.printf("0xd55c : %c\n", 0xd55c);



	}
}
