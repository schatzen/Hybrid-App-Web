package mymain2;

import myutil.MyArray2;

public class MyMain_배열2222 {

	// 오른쪽 90도 회전
	static int[][] right_90_rotate(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		// 원본과 동일한 크기의 배열 생성
		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[rows - k - 1][i];

			}
		}
		return dest;
	}

	// 왼쪽 90도 회전
	static int[][] left_90_rotate(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[k][src.length - i - 1];
			}
		}
		return dest;

	}

	// flip right left
	static int[][] flip_right_left(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[i][rows - k - 1];

			}
		}
		return dest;
	}

	// flip up down
	static int[][] flip_up_down(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[rows - i - 1][k];

			}
		}
		return dest;
	}

	// diagonal 1
	static int[][] diagonal_1(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[k][i];

			}
		}
		return dest;
	}

	// diagonal 2
	static int[][] diagonal_2(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[rows - k - 1][rows - i - 1];

			}
		}
		return dest;
	}

	// diagonal cross
	static int[][] diagonal_cross(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[rows - i - 1][rows - k - 1];

			}
		}
		return dest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyArray2 ma2 = new MyArray2();

		int[][] src = new int[5][5];
		ma2.setArray(src);

		System.out.println("=====원본=====");
		ma2.display(src);
		System.out.println();

		// 오른쪽 90 회전
		int[][] res = right_90_rotate(src);
		System.out.println("===== 오른쪽 90도 회전 =====");
		ma2.display(res);
		System.out.println();

		// 왼쪽 90 회전
		res = left_90_rotate(src);
		System.out.println("===== 오른쪽 90도 회전 =====");
		ma2.display(res);
		System.out.println();

		// flip_right_left
		res = flip_right_left(src);
		System.out.println("===== 좌우 반전====");
		ma2.display(res);
		System.out.println();

		// flip_up_down
		res = flip_up_down(src);
		System.out.println("===== 위아래 반전 =====");
		ma2.display(res);
		System.out.println();

		// diagonal_1
		res = diagonal_1(src);
		System.out.println("===== 대각선 반전=====");
		ma2.display(res);
		System.out.println();

		// diagonal_1
		res = diagonal_2(src);
		System.out.println("===== 반대 대각선 반전 =====");
		ma2.display(res);
		System.out.println();

		// diagonal_cross
		res = diagonal_cross(src);
		System.out.println("===== 대각선 크로스 =====");
		ma2.display(res);
		System.out.println();

	}

}
