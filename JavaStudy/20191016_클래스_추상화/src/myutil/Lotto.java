package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	//��÷��ȣ
	int [] win_no; //7�ڸ�
	int [] user_no;//����� �Է��� ����
	int count = 0;//��������
	int rank  = 0;//���
	
	Random rand = new Random(); 
	
	//��÷
	public void make_win_no() {
		win_no = new int[7];
		
		OUT_FOR: // Label 
		for(int i=0;i< win_no.length;i++) {
			
			int su = rand.nextInt(45)+1;//1~45
			
			//�ߺ��� üũ
			for(int k=0;k<i;k++) {
				//�������� ������
				if(su==win_no[k]) {
					i--;
					// �ٱ�for���� ���������� �̵�(i++)
					continue OUT_FOR;
				}
			}
			win_no[i] = su;
		}
		
		//������ ��ȣ�� ������ �տ� 6�ڸ� ���� ����
		//            0 1 2 3 4 5  6
		// win_no  = [1 3 5 6 7 9] 2
		Arrays.sort(win_no, 0, 0+6);
			
	}
	
	
	public void setUser_no(int[] user_no) {
		this.user_no = user_no;
		
		//�������� �� ���üũ
		calc_rank();
	}
	
	private void calc_rank() {
		// TODO Auto-generated method stub
		count = 0;
		rank  = 0;
		//�������� ����ϱ�
		for(int i=0;i<6;i++) {
			for(int k=0;k<6;k++) {
				if(user_no[i]==win_no[k]) {
					count++;
					break;
				}
			}
		}
		
		//�������ϱ�
		if(count==6) rank=1;
		else if(count==5) rank=3;
		else if(count==4) rank=4;
		else if(count==3) rank=5;
		
		//3�� �߿��� ���ʽ���ȣ �������� 2��
		if(count==5) {
			for(int i=0;i<6;i++) {
				if(user_no[i]==win_no[6]) {
					rank=2;
					break;
				}
			}
		}
		
	}


	public void display() {
		//��÷��ȣ ���
		System.out.print("��÷��ȣ:");
		for(int i=0;i<win_no.length;i++) {
			if(i<6)
			    System.out.printf("%3d",win_no[i]);
			else
				System.out.printf(" [%3d]\n",win_no[i]);
		}
		
		//������ȣ ����
		Arrays.sort(user_no);
		System.out.print("������ȣ:");
		
		for(int i=0;i<user_no.length;i++) {
		    System.out.printf("%3d",user_no[i]);
		}
		System.out.println();
		
		
		System.out.printf("��������:%d(��)\n",count);
		if(rank==0)
			System.out.println("��!!");
		else
		    System.out.printf("���:%d(��)\n",rank);
		
	}
	
	
}
