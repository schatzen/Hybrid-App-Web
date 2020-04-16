class 자료형_실수형 
{
	public static void main(String[] args) 
	{
		//실수   : 소숫점이 있는 수
		//실수형 : float  double(기본형)
		//상수   : 1.0   1.0F (float) 
		//         1.234E+4 (지수)  1.234FE+4
		//출력서식: 
		//           %f       <=소숫점이하 6자리 기본출력
		//           %e(지수) <=소숫점이하 6자리 기본출력
		//           %g       <=자릿수가 적은쪽으로 출력

		double d = 123.4567891234;
		System.out.printf("%f\n",d);
		System.out.printf("%e\n",d);
		System.out.printf("%E\n",d);
		System.out.printf("%g\n",d);

		//출력형식 : %m.nf
		//            m : 전체출력자릿수(생략)
		//            n : 소숫점이하자릿수 
		System.out.printf("[%10.3f]\n",d); //right align
		System.out.printf("[%-10.3f]\n",d);//left  align
		System.out.printf("[%010.3f]\n",d);//앞쪽빈공간 0으로채우기

		// 확보한자릿수 < 출력자릿수 => 확보자릿수 무시
		System.out.printf("[%5.3f]\n",d);
		System.out.printf("[%.3f]\n",d);

		//float형과 double형의 정밀도 확인
		System.out.printf("%.20f\n",1.2345678901234567890F);
		System.out.printf("%.20f\n",1.2345678901234567890);
















	}
}
