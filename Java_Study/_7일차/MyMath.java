//수학적기능을 모아놓는 클래스
class MyMath
{

	
	// 같은 클래스 안에서 같은 메소드 명이나, type(호출인자정보(&개수))가 다른 경우
	// Method Overload (중복 메소드)

	//Method를 작성
	//int형 더하기 기능
	public int plus(int a, int b) {
		int c = a + b;
		return c;
	}

	//double형 더하기
	public double plus(double a, double b) {
		double c = a + b;
		return c;
	}

	//빼기 기능
	public int minus(int a, int b) {
		return a - b;
	}

	//두 수 중 큰 수 구하기
	public int max(int a, int b) {
		int c = (a>b) ? a : b;
		return c;
	}

	//세 수 중 큰 수 구하기
	public int max(int a, int b, int c) {
//		int d;
//
//		if((a>b)&&(a>c)){
//			d = a;
//		} else if((b>c)&&(b>a)) {
//			d = b;
//		} else {
//			d = c;
//		}
//
//			return d;

		int max_val = (a > b) ? a: b;
		max_val = (c > max_val) ? c:max_val;

		return max_val;
	}

	//n까지의 합을 구하는 메소드
	public int hap(int n) {
		int sum=0;

		for(int i=0; i<=n; i++) {
		sum +=i;		
		}
	//계산된 결과값을 갖고 복귀합니다.
		return sum;
	}

//	    public void call(){
//		int x = 1, y = 2,res;
//
//		res = plus(x,y);
//		System.out.print(res);
//	}
}
