
/*
	예약어: 미리 정의해놓은 명령(명칭)
	식별자(identifier): 변수명,클래스명,메소드명,상수명...

*/

class 명명법 
{
	//내부클래스 : 명명법$Inner.class
	class Inner
	{

	}

	public static void main(String[] args) 
	{
		System.out.println("--[식별자 명명시 주의사항]--");
		System.out.println("--1.숫자로 시작하면 안된다");
		//			int	1kor;(X)	int kor1(O)
		System.out.println("--2.중간에 공백 띄우면 안된다");
		//			int kor 1;(X)
		System.out.println("--3.특수문자 사용 못한다(단	_$ 예외)");
		System.out.println("--	(키보드에서 숫자 알파벳 한글을 제외한 문자)");
		//	int bonus%;(X)	int ___;(O) <=가급적이면 상징성 부여
		//	int kor_1;(O)	int $$$;(O)

		System.out.println("--4.예약어는 사용못한다");
		// int public;(X)

		System.out.println("--[클래스명 명명법(권고)]--");
		System.out.println("--1.대문자로 시작");
		System.out.println("--2.2가지 이상의 단어가 조합되면 매단어 첫글자는 대문자");
		System.out.println("--3.2가지 이상의 단어가 조합되면 매단어 첫글자는 대문자 + 연결은_로");
		
		//	2.MyProfile : My + Profile
		//	2.MyProfileSchool : My + Profile + School
		//	3.My_Profile
		//	3.My_Profile_School

		System.out.println("--[변수명/매소드명 명명법(권고)]--");
		System.out.println("--1.소문자로 시작");
		System.out.println("--2.2가지 이상의 단어가 조합되면 매단어 첫글자는 대문자");
		System.out.println("--3.2가지 이상의 단어 연결은 _로해라");
		//변수
		int myMoney; //My + Money
		int my_money;
		int my_Money;

		int mymoney; //되긴하는데 별로
		int my_save_year_money; //권고	

        System.out.println("--[상수 명명법(권고)]--");
		System.out.println("--1.대문자로 시작");
		System.out.println("--2.2가지 이상의 단어 연결은 _ 로해라");

        //상수(값을 변경할 수 없는 수)  
		final double PI = 3.14;
		final String MY_PROJECT_NAME = "NAMING_TEST";
		//PI = 3.141592; (X)
        //변수(값을 변경할 수 있는 수)
		       double d  = 3.14;
		d = 3.141592;//변경...




	}

	public int two_su_hap(int a,int b){
			return a + b;
	}
}
