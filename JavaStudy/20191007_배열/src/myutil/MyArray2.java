package myutil;

public class MyArray2 {

	public void setArray(int [][] mm) {
		int su = 1;
		int rows = mm.length;//�హ��
		for(int i=0;i<rows;i++) {//��÷�� 
			
			for(int k=0;k<mm[i].length;k++) {//��÷��
				
				mm[i][k] = su;
				su++;
			}
		}
	}
	
	public void display(int [][] mm) {
		
		for(int i=0;i<mm.length;i++) {//��÷��
			
			for(int k=0;k<mm[i].length;k++) {//��÷��
				
				System.out.printf("%4d", mm[i][k]);
				
			}
			
			//�ٹٲٱ�
			System.out.println();
		}
	}
	
	//��ü�� valä���
	public void fill(int [][] mm, int val) {
		
		for(int i=0;i<mm.length;i++) {//��÷�� 
			
			for(int k=0;k<mm[i].length;k++) {//��÷��
				
				mm[i][k] = val;
				
			}
		}
	}
	
	//������ ��(rowIndex)�� val�� ä���
	public void fill(int [][] mm, int rowIndex, int val) {
		
		for(int k=0;k<mm[rowIndex].length;k++) {//��÷��
			
			mm[rowIndex][k] = val;
			
		}
	}
	
	public void display_block(int [][] mm) {
		
		for(int i=0;i<mm.length;i++) {//��÷��
			
			for(int k=0;k<mm[i].length;k++) {//��÷��
				
				if(mm[i][k]==1)
					System.out.printf("%s","��");
				else
					System.out.printf("%s","  ");
				
			}
			
			//�ٹٲٱ�
			System.out.println();
		}
	}
	
	
	
}
