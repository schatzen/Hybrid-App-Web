//����������� ��Ƴ��� Ŭ����
class MyMath
{

	
	// ���� Ŭ���� �ȿ��� ���� �޼ҵ� ���̳�, type(ȣ����������(&����))�� �ٸ� ���
	// Method Overload (�ߺ� �޼ҵ�)

	//Method�� �ۼ�
	//int�� ���ϱ� ���
	public int plus(int a, int b) {
		int c = a + b;
		return c;
	}

	//double�� ���ϱ�
	public double plus(double a, double b) {
		double c = a + b;
		return c;
	}

	//���� ���
	public int minus(int a, int b) {
		return a - b;
	}

	//�� �� �� ū �� ���ϱ�
	public int max(int a, int b) {
		int c = (a>b) ? a : b;
		return c;
	}

	//�� �� �� ū �� ���ϱ�
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

	//n������ ���� ���ϴ� �޼ҵ�
	public int hap(int n) {
		int sum=0;

		for(int i=0; i<=n; i++) {
		sum +=i;		
		}
	//���� ������� ���� �����մϴ�.
		return sum;
	}

//	    public void call(){
//		int x = 1, y = 2,res;
//
//		res = plus(x,y);
//		System.out.print(res);
//	}
}
