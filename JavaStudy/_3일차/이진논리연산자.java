class 이진논리연산자
{
	public static void main(String[] args) 
	{
		// &  ^  |
        int birthday = 0x19901225; 

        //             0x19901225 
		//      >>> 16 0x00001990(1225) 
		//출생년도 추출
		int year = birthday >>> 16;

		//출생월 추출
		//             0x19901225 
		//      >> 8   0x00199012(25) 
		//      &      0x000000ff
        //                         1   2 
		//            9  1001    0001 0010
		//         &  0  0000    1111 1111
		//               0000    0001 0010 
		int month = birthday >> 8 & 0x000000ff;

        //일추출
		//             0x19901225 
		//      &      0x000000ff
		//             0x00000025  
		int day = birthday & 0x000000ff;

        System.out.printf("%x\n", birthday);
		//월변경 : 1)소거  2)추가
		//birthday = birthday & 0xffff00ff;
        //             0x19901225     1001 (9)
		//      ^      0x00001200     0000 (0) 
		//                            1001
        birthday = birthday ^ 0x00001200; 
        //추가
		birthday = birthday | 0x00000800;

		System.out.printf("%x\n", birthday);

		
		
		System.out.printf("출생년도:%x년\n",year);
		System.out.printf("출생월:%02x월\n",month);
		System.out.printf("출생일:%02x월\n",day);





	}
}
