package myutil;

public class MyMath {

	//�ܺο��� ��ü���� ���ϰ�...
	private MyMath() {
		// TODO Auto-generated constructor stub
	}
	
	public static int plus(int a,int b) {
		return a+b;
	}
	
	public static int max(int a,int b) {
		return (a > b) ? a : b;
	}
	
	public static int hap(int n) {
		int sum = 0;
		for(int i=0;i<=n;i++) {
			sum = sum + i;
		}
		return sum;
	}
}
