class Ex_Method1
{
	public static void main(String[] args) 
	{
		//class MyMath 객체 생성
		MyMath mm = new MyMath();

		 int x = 15, y = 3, z = 12;
		 double d1=10.0, d2=3.0, d3;
		 int res;

		//plus(int,int)호풀시 메소드 명 + 인자정보
		//int형 plus메소드 호출
		res = mm.plus(x,y);
		System.out.printf("%d + %d = %d\n",x,y,res);

		//double형 plus메소드 호출
		d3 = mm.plus(d1,d2);
		System.out.printf("%.1f + %.1f = %.1f\n",d1,d2,d3);

		//빼기 출력
		res = mm.minus(x,y);
		System.out.printf("%d - %d = %d\n",x,y,res);

		//큰 수 구하기 출력
		res = mm.max(x,y);
		System.out.printf("%d와(과) %d수 중 큰 수는 %d입니다.\n",x,y,res);	

		res = mm.max(x,y,z);
		System.out.printf("%d와(과) %d와(과) %d 수 중 큰 수는 %d입니다.\n",x,y,z,res);	

		//x까지의 합
		res = mm.hap(x);
		System.out.printf("1~%d까지의 합은 %d입니다.\n",x,res);
	}
}
