class ����Ʈ������
{
	public static void main(String[] args) 
	{
		//����Ʈ ������ : >>  >>>   <<
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
        // >> ������� ��ȣ�� ä��
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>4));
		// >>> ������� 0���� ä��
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>>4));

        System.out.println("----- (-1) shift -----");
        n = -1;
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n));
        // >> ������� ��ȣ�� ä��
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>4));
		// >>> ������� 0���� ä��
		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n>>>4));

		System.out.printf("[%32s]\n", 
			              Integer.toBinaryString(n<<4));




	}
}
