class MyMath2
{
	//정수절대값 구하기
	public int abs(int n){
       //코드작성
       return (n<0) ? -n : n ;
	}
    //실수절대값  
	public double abs(double d){ 
	   return (d<0) ? -d : d ;
	}

	//2수중 작은수
	public int min(int a,int b){ 
		return (a>b) ? b : a; 
	}
    //3수중 작은수
	public int min(int a,int b,int c){ 
	    int min_val = a > b ? b : a;
		if(min_val > c) min_val = c;
		return min_val; 
    }

	//짝수의합
	public int hap_even(int n){ 
	    int sum = 0;
		for(int i=0;i<=n;i++){
			if(i%2==0)
				sum += i;
		}
		return sum; 
	}

	//홀수의합
	public int hap_odd(int n){ 
	
		int sum = 0;
		for(int i=0;i<=n;i++){
			if(i%2==1)
				sum += i;
		}
		return sum; 
	}
	
    //n까지의 수중에서 m의 배수의 합
	// hap(10,5);
	public int hap(int n,int m){ 
	
		int sum = 0;
		for(int i=0;i<=n;i++){
			if(i%m==0)
				sum += i;
		}
		return sum; 
	}

	//factorial 구하기: 4!=4*3*2*1
    public double factorial(int n){ 
	    double result = 1.0;
		for(int i=n;i>0;i--){
           result= result * i;
		}
		return result;
	}

	// n까지의 수중 솟(소)수를 출력
	// 1과 자신의 수로만 나눠지는 수
	// 2 3 5 7 11 13 17 19 23
	// sosu(25);
	public void sosu(int n){ 
		
		for(int i=2;i<=n;i++) {
			
			boolean bSosu = true;
			//솟수체크 로직
			//for(int k=2;k<i;k++) {
			for(int k=2;k<=i/2;k++) {
				
				//나눠지면 솟수가 아님
				if(i%k==0) {
					bSosu=false;
					break;
				}
			}
			
			if(bSosu) {//솟수면
				System.out.print(i  + "  ");
			}
		}
		
		System.out.println();//줄바꾸기
			
		
		
	}



}
