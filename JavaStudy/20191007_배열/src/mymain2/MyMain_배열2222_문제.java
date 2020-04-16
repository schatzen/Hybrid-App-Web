package mymain2;

import myutil.MyArray2;

public class MyMain_�迭2222_���� {

	static int[][] right_90_rotate(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[rows-k-1][i];
			}
		}
		return dest;
	}
	
	static int[][] left_90_rotate(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[k][cols-i-1];
			}
		}
		return dest;
	}
	
	static int[][] flip_left_rigth(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[i][cols-k-1];
			}
		}
		return dest;
	}
	
	static int[][] flip_up_down(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[rows-i-1][k];
			}
		}
		return dest;
	}
	
	static int[][] flip_diagonal1(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[cols-k-1][rows-i-1];
			}
		}
		return dest;
	}
	
	
	static int[][] flip_diagonal2(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[k][i];
			}
		}
		return dest;
	}
	
	static int[][] flip_diagonal_cross(int[][] src) {
		int rows = src.length;//���
		int cols = src[0].length;//����
        //������ ������ ũ���� �迭 ����		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//��÷��
			for(int k=0;k<cols;k++) {//��÷��
				dest[i][k] = src[rows-i-1][cols-k-1];
			}
		}
		return dest;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyArray2 ma2 = new MyArray2();
		
		int [][] src = new  int[5][5];
		ma2.setArray(src);
		
		System.out.println("====== ���� ======");
		ma2.display(src);
		
		//������ 90 ȸ��
		int [][] res = right_90_rotate(src);
		System.out.println("====== ������ 90 ȸ�� ======");
		ma2.display(res);
		
		//���� 90 ȸ��
		res = left_90_rotate(src);
		System.out.println("====== ���� 90 ȸ�� ======");
		ma2.display(res);
		
		//�¿� ������
		res = flip_left_rigth(src);
		System.out.println("====== �¿� ������ ======");
		ma2.display(res);
		
		
		//���� ������
		res = flip_up_down(src);
		System.out.println("====== ���� ������ ======");
		ma2.display(res);
		
		//�밢 ������
		res = flip_diagonal1(src);
		System.out.println("====== �밢 ������ ======");
		ma2.display(res);
		
		//���밢 ������
		res = flip_diagonal2(src);
		System.out.println("====== ���밢 ������ ======");
		ma2.display(res);
		
		// �밢 cross
		//res = flip_diagonal1(src);
		//res = flip_diagonal2(res);
		res = flip_diagonal_cross(src);
		System.out.println("====== �밢 Cross ������ ======");
		ma2.display(res);
		
		
		
		
        
		
		
	}

}
