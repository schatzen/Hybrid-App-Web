//수학적기능을 모아놓는 클래스
class MyMath
{
	//Method를 작성
	//Method Overload(중복 메소드)
	// : 메소드명을 같고 호출인자정보가 틀린메소드
	//int형 더하기 기능
    public int plus(int a,int b){
		int c = a + b;
		return c;
	}

    //double형 더하기 기능 
	public double plus(double a,double b){
        double c = a + b;
		return c;
	}


	//빼기 기능
    public int minus(int a,int b){
        return a - b; 
	}
	//2수중 큰수 구하기
	public int max(int a,int b){
        int c =  (a>b) ? a : b;
		return c;
	}

	//3수중 큰수 구하기
	public int max(int a,int b,int c){
         
        int max_val = (a > b) ? a : b;

		max_val = (c > max_val) ? c : max_val;
          
        return max_val; 
	}

	//n까지 합 구하기
	public int hap(int n){
        
		int sum = 0;
		for(int i=1;i<=n ; i++){
           //i =  1 2 3 ... 10
		   sum = sum + i;
		}
        //계산된 결과값을 갖고 복귀 
        return sum;
	}
}

