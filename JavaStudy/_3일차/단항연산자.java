class ���׿�����
{
	public static void main(String[] args) 
	{
		//���׿�����: ~ !  (++ -- )  -(��ȣ)  (cast)


        //������ Not������ :  ~  (tilde)
		//                      1������ ���Ѵ�
		int n = 10;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));

		n = -1;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));

		
		//�Ϲݳ� Not������:  !
        int a = 10, b = 5;
		System.out.printf("%d > %d => %b\n", a, b, a > b);
		System.out.printf("!(%d > %d) => %b\n", a, b, !(a > b) );
		System.out.println(!true);
		System.out.println(!false);

		//����������:  ++  --
		/*
             ++����    : ������
			   ����++  : ������
		*/
        int m = 10;
		System.out.printf("m=%d\n",m);
		m++;  // m = m + 1  <= �ڽ��ǰ��� 1����
		System.out.printf("m=%d\n",m);
		m--;  // m = m - 1  <= �ڽ��ǰ��� 1����
		System.out.printf("m=%d\n",m);

		a=10;
		b=3;
        //������: ��翬�꿡 �ռ� ��������
		//������: ��翬���Ŀ� ���߿� ����

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
 
        //��ȣ������:  - 
        int k = -100;
		
		k = -k;// -1 * -100

        k = -10;

        if( k<0 )
			m = -k;
		else
			m = k;

		// m = (k<0) ? -k : k ;

		System.out.printf("|%d|=%d\n", k,m);
         

		//��������ȯ������: cast������  (Type)��

		/*
            ����ȯ
			1.�ڵ�����ȯ(������)
			  1)���Խ� :�º��׿� ��������(��,�º����� Ŭ���)
			    (ġȯ)   
			  2)����� :�ڷ����� ū������ ��ȯ�� ����

			2.��������ȯ(�����)
		*/

		//����(ġȯ)��
		double d;
        //double = int (X)
		//�º���=�캯��
		d = 10;  // 1)10->10.0  2)d = 10.0

        //�ڵ�����ȯ�Ұ�=>��������ȯ 
		float f = (float)d;

		//���������ȯ
		//double = float + long 
		//1)1->1.0F 2) 1.0F+1.0F 3)2.0F->2.0  4)d = 2.0
		d  = 1.0F + 1L; 


		byte b1 = 1, b2= 2 , b3;
		b3 = (byte)(b1 + b2);

		int res = b1 + b2;

		/*
		      //int������ �����ڷ����� ������ int
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
