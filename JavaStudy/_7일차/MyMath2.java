class MyMath2
{
	//�������밪 ���ϱ�
	public int abs(int n){
       //�ڵ��ۼ�
       return (n<0) ? -n : n ;
	}
    //�Ǽ����밪  
	public double abs(double d){ 
	   return (d<0) ? -d : d ;
	}

	//2���� ������
	public int min(int a,int b){ 
		return (a>b) ? b : a; 
	}
    //3���� ������
	public int min(int a,int b,int c){ 
	    int min_val = a > b ? b : a;
		if(min_val > c) min_val = c;
		return min_val; 
    }

	//¦������
	public int hap_even(int n){ 
	    int sum = 0;
		for(int i=0;i<=n;i++){
			if(i%2==0)
				sum += i;
		}
		return sum; 
	}

	//Ȧ������
	public int hap_odd(int n){ 
	
		int sum = 0;
		for(int i=0;i<=n;i++){
			if(i%2==1)
				sum += i;
		}
		return sum; 
	}
	
    //n������ ���߿��� m�� ����� ��
	// hap(10,5);
	public int hap(int n,int m){ 
	
		int sum = 0;
		for(int i=0;i<=n;i++){
			if(i%m==0)
				sum += i;
		}
		return sum; 
	}

	//factorial ���ϱ�: 4!=4*3*2*1
    public double factorial(int n){ 
	    double result = 1.0;
		for(int i=n;i>0;i--){
           result= result * i;
		}
		return result;
	}

	// n������ ���� ��(��)���� ���
	// 1�� �ڽ��� ���θ� �������� ��
	// 2 3 5 7 11 13 17 19 23
	// sosu(25);
	public void sosu(int n){ 
		
		for(int i=2;i<=n;i++) {
			
			boolean bSosu = true;
			//�ڼ�üũ ����
			//for(int k=2;k<i;k++) {
			for(int k=2;k<=i/2;k++) {
				
				//�������� �ڼ��� �ƴ�
				if(i%k==0) {
					bSosu=false;
					break;
				}
			}
			
			if(bSosu) {//�ڼ���
				System.out.print(i  + "  ");
			}
		}
		
		System.out.println();//�ٹٲٱ�
			
		
		
	}



}
