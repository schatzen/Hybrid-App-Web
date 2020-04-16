package mymain2;

import myutil.MyArray2;

public class MyMain_배열2222_문제 {

	static int[][] right_90_rotate(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
				dest[i][k] = src[rows-k-1][i];
			}
		}
		return dest;
	}
	
	static int[][] left_90_rotate(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
				dest[i][k] = src[k][cols-i-1];
			}
		}
		return dest;
	}
	
	static int[][] flip_left_rigth(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
				dest[i][k] = src[i][cols-k-1];
			}
		}
		return dest;
	}
	
	static int[][] flip_up_down(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
				dest[i][k] = src[rows-i-1][k];
			}
		}
		return dest;
	}
	
	static int[][] flip_diagonal1(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
				dest[i][k] = src[cols-k-1][rows-i-1];
			}
		}
		return dest;
	}
	
	
	static int[][] flip_diagonal2(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
				dest[i][k] = src[k][i];
			}
		}
		return dest;
	}
	
	static int[][] flip_diagonal_cross(int[][] src) {
		int rows = src.length;//행수
		int cols = src[0].length;//열수
        //원본과 동일한 크기의 배열 생성		
		int [][] dest = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {//행첨자
			for(int k=0;k<cols;k++) {//열첨자
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
		
		System.out.println("====== 원본 ======");
		ma2.display(src);
		
		//오른쪽 90 회전
		int [][] res = right_90_rotate(src);
		System.out.println("====== 오른쪽 90 회전 ======");
		ma2.display(res);
		
		//왼쪽 90 회전
		res = left_90_rotate(src);
		System.out.println("====== 왼쪽 90 회전 ======");
		ma2.display(res);
		
		//좌우 뒤집기
		res = flip_left_rigth(src);
		System.out.println("====== 좌우 뒤집기 ======");
		ma2.display(res);
		
		
		//상하 뒤집기
		res = flip_up_down(src);
		System.out.println("====== 상하 뒤집기 ======");
		ma2.display(res);
		
		//대각 뒤집기
		res = flip_diagonal1(src);
		System.out.println("====== 대각 뒤집기 ======");
		ma2.display(res);
		
		//역대각 뒤집기
		res = flip_diagonal2(src);
		System.out.println("====== 역대각 뒤집기 ======");
		ma2.display(res);
		
		// 대각 cross
		//res = flip_diagonal1(src);
		//res = flip_diagonal2(res);
		res = flip_diagonal_cross(src);
		System.out.println("====== 대각 Cross 뒤집기 ======");
		ma2.display(res);
		
		
		
		
        
		
		
	}

}
