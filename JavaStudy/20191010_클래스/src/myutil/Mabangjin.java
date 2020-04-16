package myutil;

public class Mabangjin {

	int chasu;
	int [][] mabang;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//������ ����
		this.make_mabangjin();
	}

	private void make_mabangjin() {
		// TODO Auto-generated method stub
		//�������� ������ �迭 ����
		mabang = new int[chasu][chasu];
		
		int row = 0;
		int col = chasu/2;
		int su  = 1;
		
		//ù��°ĭ ���� ä���
		mabang[row][col] = su++;
		
		//ä���
		for(int i=0;i<chasu*chasu-1;i++) {
			//�밢���� �̵�
			row--;
			col++;
			
			//���� ������ ��� �������
			// =>������ġ���� �Ʒ��� �̵�
			if(row < 0 && col==chasu) {
				row+=2;//�Ʒ��� 2ĭ
				col--; //����   1ĭ
			}else if(row < 0) { //���� �������
				                // => �� �Ʒ��� �̵� 
				row = chasu-1; 
				
			}else if(col==chasu) { //���������� �������
				                   // => �� ������ �̵�  
				col = 0;
			}
			
			//�̹� ���� ä���� �ֳ�?
			// => ������ġ�� �ٷ� �Ʒ��� �̵�
			if(mabang[row][col] != 0) {
				row+=2;//�Ʒ��� 2ĭ
				col--; //����   1ĭ
			}
			
			//��ä���
			mabang[row][col] = su++;
			
		}
		
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
		//���հ�
		int [] col_sum = new int[chasu];
		
		int diagonal2_sum = 0;
		
		for(int i=0;i<chasu;i++) {
			int row_sum = 0;//���հ�
			for(int k=0;k<chasu;k++) {
				System.out.printf("%4d",mabang[i][k]);
				row_sum += mabang[i][k];
				
				col_sum[k] += mabang[i][k];
				
				//���밢�� ��
				if(i==k)
					diagonal2_sum += mabang[i][k];
			}
			System.out.printf("%4d",row_sum);
			
			System.out.println();//�ٹٲٱ�
		}
		
		
		//���հ� ���
		for(int k=0;k<chasu;k++) {
			System.out.printf("%4d",col_sum[k]);
		}
		
		//���밢�� ���
		System.out.printf("%4d",diagonal2_sum);
		
		System.out.println();//�ٹٲٱ�
		
		
	}
	
	
	
	
}
