
public class Ex_Method1
{
	public static void main(String[] args) 
	{

		// class MyMath객체 생성
		MyMath mm = new MyMath();
  
        int x = 10, y = 5,res;
		double d1=10.0,d2=3.0,d3;
		//    plus(int,int)호출시 메소드명+인자정보
		res = mm.plus(x,y);
		System.out.printf("%d + %d = %d\n",x,y,res);

		d3 = mm.plus(d1,d2);
		System.out.printf("%.1f + %.1f = %.1f\n",d1,d2,d3);



		//빼기기능 이용
		res = mm.minus(x,y);
		System.out.printf("%d - %d = %d\n",x,y,res);

		//큰수 구하기
		res = mm.max(x,y);
		System.out.printf("%d와(과) %d수중 큰수는 %d\n",x,y,res);

        // x까지의 합
		res = mm.hap(x);
	    System.out.printf("1~%d까지의 합=%d\n",x,res);

		//3수중 큰수
		int a = 10,b=2,c=7;
		res = mm.max(a,b,c);
 
        System.out.printf("%d,%d,%d수중 가장큰수 %d\n",a,b,c,res);

	}
}
