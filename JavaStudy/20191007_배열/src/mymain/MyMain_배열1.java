package mymain;

public class MyMain_�迭1 {

	
	
	/* ���ú��� �迭�� ���Ͽ� ���θ� �մϴ� */
	
	// ��������ġ �ּ� �ޱ�: Ctrl + Shift + /
	// ��������ġ �ּ� ����: Ctrl + Shift + \ 
	
	
	public static void display_array(int [] mr2) {
		                          // int [] mr2 = mr
		System.out.printf("mr2's length=%d\n", mr2.length);
		System.out.print("[ ");
		for(int i=0;i<mr2.length;i++) {
			System.out.print(mr2[i] + " ");
		}
		System.out.println("]");
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1���� �迭���� ����
		int [] mr;
		
		//1���� �迭 ����
		mr = new int[4];
		
		
		System.out.printf("mr's length=%d\n", mr.length);
		
		//����ҿ� ���� �ֱ�
		//÷�� = ÷��+1
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;
		
		//�迭���� ����
		// 1.�ϰ�ó��   
		// 2.�ս��� ���յ�����(�迭)  �ٸ���ü���� ����
		
		//�ݺ����� �̿��ؼ� �ϰ�ó��
		for(int i=0;i< mr.length ;i++) { //i = 0 1 2 3
			mr[i] = i + 1;
			System.out.printf("mr[%d]=%d\n", i, mr[i]);
		}
		
		
		display_array(mr);
		
		
		
		
	}

}
