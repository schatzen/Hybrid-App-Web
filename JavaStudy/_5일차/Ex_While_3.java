class Ex_While_3
{
	public static void main(String[] args) throws Exception
	{
		//키보드로부터 입력
        System.out.println("종료하려면 Ctrl+Z");
		int count=0;
		while(true)
		{
            //키보드 버퍼에서 1byte씩 읽어오기  
            int ch = System.in.read();
			//Ctrl+Z치면 -1 반환
			if(ch==-1) break;

            count++;
			System.out.printf("%c",ch);
		}

		System.out.printf("입력문자수:%d\n",count);

		System.out.println("--End--");


	}
}
