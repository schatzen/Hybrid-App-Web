class 단항연산자
{
	public static void main(String[] args) 
	{
		//단항연산자: ~ !  (++ -- )  -(부호)  (cast)


        //이진논리 Not연산자 :  ~  (tilde)
		//                      1보수를 취한다
		int n = 10;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));

		n = -1;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));

		
		//일반논리 Not연산자:  !
        int a = 10, b = 5;
		System.out.printf("%d > %d => %b\n", a, b, a > b);
		System.out.printf("!(%d > %d) => %b\n", a, b, !(a > b) );
		System.out.println(!true);
		System.out.println(!false);

		//증감연산자:  ++  --
		/*
             ++변수    : 전위형
			   변수++  : 후위형
		*/
        int m = 10;
		System.out.printf("m=%d\n",m);
		m++;  // m = m + 1  <= 자신의값을 1증가
		System.out.printf("m=%d\n",m);
		m--;  // m = m - 1  <= 자신의값을 1감소
		System.out.printf("m=%d\n",m);

		a=10;
		b=3;
        //전위형: 모든연산에 앞서 먼저실행
		//후위형: 모든연산후에 나중에 실행

		int c = ++a  + b--;
        // 1)++a  2)c = a + b  3)b--
		//     a   b   c
		//     11  2   14

		System.out.printf("a=%d b=%d c=%d\n", a, b, c);

        System.out.printf("a=%d a=%d\n", ++a, a--);

        b= 2;
		c = ++b + ++b;
		// 1)++b  2)++b  3) c = ++b + ++b;
		//    3      4          3   +  4 
        System.out.printf("b=%d c=%d\n",b,c);
 
        //부호연산자:  - 
        int k = -100;
		
		k = -k;// -1 * -100

        k = -10;

        if( k<0 )
			m = -k;
		else
			m = k;

		// m = (k<0) ? -k : k ;

		System.out.printf("|%d|=%d\n", k,m);
         

		//강제형변환연산자: cast연산자  (Type)값

		/*
            형변환
			1.자동형변환(묵시적)
			  1)대입시 :좌변항에 맞춰진다(단,좌변항이 클경우)
			    (치환)   
			  2)연산시 :자료형이 큰쪽으로 변환후 연산

			2.강제형변환(명시적)
		*/

		//대입(치환)시
		double d;
        //double = int (X)
		//좌변항=우변항
		d = 10;  // 1)10->10.0  2)d = 10.0

        //자동형변환불가=>강제형변환 
		float f = (float)d;

		//연산시형변환
		//double = float + long 
		//1)1->1.0F 2) 1.0F+1.0F 3)2.0F->2.0  4)d = 2.0
		d  = 1.0F + 1L; 


		byte b1 = 1, b2= 2 , b3;
		b3 = (byte)(b1 + b2);

		int res = b1 + b2;

		/*
		      //int형보다 작은자료형의 연산결과 int
              byte + byte -> int
			  byte + short-> int
			  short+ short-> int

			  byte + int  -> int
			  byte + long -> long
              int  + float-> float
			  float+ double->double
		*/




	













	}
}
