class 관계연산자
{
	public static void main(String[] args) 
	{
		//관계연산자:  >  >=  <   <=  ==  !=
		//            결과는 true or false
		//            제어문(if,for,while)에서 조건식으로 활용 
		int a = 3,b=2;
		
		System.out.printf("%d > %d : %b\n",  a, b, a > b);
		System.out.printf("%d >= %d : %b\n", a, b, a >= b);
		System.out.printf("%d < %d : %b\n",  a, b, a < b);
		System.out.printf("%d <= %d : %b\n", a, b, a <= b);
		System.out.printf("%d == %d : %b\n", a, b, a == b);
		System.out.printf("%d != %d : %b\n", a, b, a != b);

	}
}
