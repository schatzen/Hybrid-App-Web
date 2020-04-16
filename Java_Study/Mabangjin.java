package myutil;

public class Mabangjin {

	int chasu;
	int[][] mabang;

	public void setChasu(int chasu) {
		this.chasu = chasu;

		// ������ ����
		this.make_mabangjin();
	}

	private void make_mabangjin() {
		// �������� ������ �迭 ����
		mabang = new int[chasu][chasu];

		int row = 0;
		int col = chasu / 2;
		int su = 1;

		mabang[row][col] = su++;

		for (int i = 0; i < chasu * chasu - 1; i++) {

			row--;
			col++;

			// ���� ������ ��� ���� ���
			if (row < 0 && col == chasu) {
				row += 2;
				col--;

			} else if (row < 0) { // ���� ������� > �� �Ʒ��� �̵�
				row = chasu - 1;

			} else if (col == chasu) {// ���������� ���� ��� > �� ������ �̵�
				col = 0;

			}

			// �̹� ���� ä�����ֳ�? // > ���� ��ġ�� �ٷ� �Ʒ�
			if (mabang[row][col] != 0) {
				col--;
				row += 2;
			}

			// �� ä���
			mabang[row][col] = su++;

		}
	}

	/*
	 * while (true) {
	 * 
	 * 
	 * 
	 * if (row == -1) { row = chasu - 1; mabang[row][col] = su;
	 * 
	 * } else if (row == 5) { row = 0; mabang[row][col] = su;
	 * 
	 * } else if (mabang[row][col] != 0) { col--; row += 2; mabang[row][col] = su;
	 * 
	 * } else if (row < 0 && col == chasu) { row += 2; col--; }
	 * 
	 * if (su == chasu * chasu) break;
	 * 
	 * row--; col++; su++;
	 */

	public void display() {

		int[] col_sum = new int[chasu];
		int diagonal_sum = 0;

		for (int i = 0; i < chasu; i++) {
			int row_sum = 0;

			for (int k = 0; k < chasu; k++) {
				System.out.printf("%4d", mabang[i][k]);
				row_sum += mabang[i][k];
				col_sum[k] += mabang[k][i];

				if (i == k)
					diagonal_sum += mabang[i][k];
			}

			System.out.printf("%4d", row_sum);
			System.out.println();
		}

		for (int i = 0; i < chasu; i++) {
			System.out.printf("%4d", col_sum[i]);
		}

		System.out.printf("%4d", diagonal_sum);
		System.out.println();

	}

}
