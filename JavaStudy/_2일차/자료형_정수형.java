class 자료형_정수형 
{
	public static void main(String[] args) 
	{
		//정수:소숫점이 없는수
		//정수형: byte short   int  long
		//                  (기본형)  
		//상수선언: 10  0  0L 10L(long형 상수) 
		//출력서식: %d  %o  %x
		//        %d(decimal) :10진수
		//        %o(octal)   : 8진수
		//        %x(hexa)    :16진수  

		int n = 100;
		//n's값을 각진수로 출력
		System.out.printf("10진수=%d\n",n);
		System.out.printf(" 8진수=0%o\n",n);
		System.out.printf("16진수=0x%x\n",n);

		//각진수의 값을 10진수로 출력
		System.out.printf("%d\n", 100);
		System.out.printf("%d\n", 0144);
		System.out.printf("%d\n", 0x64);

        //출력서식의 형식 %md
		//      m:출력전체자릿수
		//      m<0 : left  align
		//      m>0 : right align 
		n = 123;
		System.out.printf("[%10d]\n", n); //right
		System.out.printf("[%010d]\n", n); //right
		System.out.printf("[%-10d]\n", n);//left
		//System.out.printf("[%-010d]\n", n);// error

        // 확보한자릿수 < 출력자릿수 => 무시  
	    System.out.printf("[%2d]\n",n); 

		System.out.printf("[%32s]\n", 
			         Integer.toBinaryString(n));
	
	}
}
