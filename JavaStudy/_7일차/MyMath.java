//����������� ��Ƴ��� Ŭ����
class MyMath
{
	//Method�� �ۼ�
	//Method Overload(�ߺ� �޼ҵ�)
	// : �޼ҵ���� ���� ȣ������������ Ʋ���޼ҵ�
	//int�� ���ϱ� ���
    public int plus(int a,int b){
		int c = a + b;
		return c;
	}

    //double�� ���ϱ� ��� 
	public double plus(double a,double b){
        double c = a + b;
		return c;
	}


	//���� ���
    public int minus(int a,int b){
        return a - b; 
	}
	//2���� ū�� ���ϱ�
	public int max(int a,int b){
        int c =  (a>b) ? a : b;
		return c;
	}

	//3���� ū�� ���ϱ�
	public int max(int a,int b,int c){
         
        int max_val = (a > b) ? a : b;

		max_val = (c > max_val) ? c : max_val;
          
        return max_val; 
	}

	//n���� �� ���ϱ�
	public int hap(int n){
        
		int sum = 0;
		for(int i=1;i<=n ; i++){
           //i =  1 2 3 ... 10
		   sum = sum + i;
		}
        //���� ������� ���� ���� 
        return sum;
	}
}

