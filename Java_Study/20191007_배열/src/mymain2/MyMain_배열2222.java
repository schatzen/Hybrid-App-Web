package mymain2;

import myutil.MyArray2;

public class MyMain_�迭2222 {

	// ������ 90�� ȸ��
	static int[][] right_90_rotate(int[][] src) {
		int rows = src.length;
		int cols = src[0].length;

		// ������ ������ ũ���� �迭 ����
		int[][] dest = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				dest[i][k] = src[rows - k - 1][i];

			}
		}
		return dest;
	}

	// ���� 90�� ȸ��
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

		System.out.println("=====����=====");
		ma2.display(src);
		System.out.println();

		// ������ 90 ȸ��
		int[][] res = right_90_rotate(src);
		System.out.println("===== ������ 90�� ȸ�� =====");
		ma2.display(res);
		System.out.println();

		// ���� 90 ȸ��
		res = left_90_rotate(src);
		System.out.println("===== ������ 90�� ȸ�� =====");
		ma2.display(res);
		System.out.println();

		// flip_right_left
		res = flip_right_left(src);
		System.out.println("===== �¿� ����====");
		ma2.display(res);
		System.out.println();

		// flip_up_down
		res = flip_up_down(src);
		System.out.println("===== ���Ʒ� ���� =====");
		ma2.display(res);
		System.out.println();

		// diagonal_1
		res = diagonal_1(src);
		System.out.println("===== �밢�� ����=====");
		ma2.display(res);
		System.out.println();

		// diagonal_1
		res = diagonal_2(src);
		System.out.println("===== �ݴ� �밢�� ���� =====");
		ma2.display(res);
		System.out.println();

		// diagonal_cross
		res = diagonal_cross(src);
		System.out.println("===== �밢�� ũ�ν� =====");
		ma2.display(res);
		System.out.println();

	}

}
