package mymain;

public class MyMain_�迭Ȱ��2 {

	//Elipsis : �����ӱ�ȣ <= ���ڰ��� �������� �������
	static void display(int ... nr) {
		//         int [] nr = { 10 };
		//         int [] nr = { 10 , 20 };
		//         int [] nr = { 10 , 20 , 30 };
		System.out.print("[ ");
		for(int i=0;i<nr.length;i++) {
			System.out.printf("%d ", nr[i]);
		}
		System.out.println("]");
	}
	
	//n���� ���߿��� ���� ū�� ���ϱ�
	static int max(int ... nr) {

		// int [] nr = { 10, 50, 15 };
		int max_val = Integer.MIN_VALUE;
		for(int i=0;i<nr.length;i++) {
			max_val = (nr[i] > max_val) ? nr[i] : max_val; 
		}
		return max_val;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display(10);
        display(10,20);
        display(10,20,30);
        
        int a=10,b=50,c=15,res;
        res = max(a,b,c);
        System.out.printf("%d,%d,%d�� ���� ū�� %d\n", a,b,c,res);
        
        
	}

}
