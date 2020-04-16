package myutil;

public class AdvanceCalc  extends BaseCalc {
	
	public int hap(int n) {
		int sum = 0;
		
		for(int i=0;i<=n;i++) {
			//�θ��� ����� ���
			sum =  super.plus(sum, i);//sum + i;
		}
		
		return sum;
	}
	
	// n's m��  :  2's 3�� => 2*2*2 
	public int pow(int n,int m) {
		int res = 1;
		for(int i=0;i<m;i++) {
			//�θ��� ����� ���
			res = super.multiply(res, n);//res * n;
		}
		return res;
	}
	
}
