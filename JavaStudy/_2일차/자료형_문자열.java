class 자료형_문자열 
{
	public static void main(String[] args) 
	{
		//문자열 : 1개이상의 문자가 나열된 구조
		//상수   : "ABC" <= 'A''B''C' 
		//출력서식: %s

        String name = "홍길동" ;
		System.out.printf("name's value: %s\n",name);

		String addr = "서울시 마포구 창전동";
		//서식형식 : %m.ns
		//            m:전체자릿수
		//            n:출력문자수
		

		System.out.printf("[%10.7s]\n", addr);

	}
}
