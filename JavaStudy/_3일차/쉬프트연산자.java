class 쉬프트연산자
{
	public static void main(String[] args) 
	{
		//쉬프트 연산자 : >>  >>>   <<
		int n = 10;
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n));

		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>2));

		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n<<2));

        n = 0xf0f0f0f0;    // f=15   1111
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n));
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>2));
        // >> 빈공간은 부호로 채움
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>4));
		// >>> 빈공간은 0으로 채움
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>>4));

        System.out.println("----- (-1) shift -----");
        n = -1;
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n));
        // >> 빈공간은 부호로 채움
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>4));
		// >>> 빈공간은 0으로 채움
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>>4));

		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n<<4));




	}
}
