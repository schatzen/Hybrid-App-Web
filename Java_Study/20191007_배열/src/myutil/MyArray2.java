package myutil;

public class MyArray2 {

	public void setArray(int[][] mm) {

		int value = 1;

		for (int i = 0; i < mm.length; i++) {
			for (int k = 0; k < mm[i].length; k++) {
				mm[i][k] = value++;

				// mm[i][k]=value;
				// value ++;
				// �Ȱ��� ��!

			}
		}

	}

	public void display(int[][] mm) {
		for (int i = 0; i < mm.length; i++) { // ��÷��
			for (int k = 0; k < mm[i].length; k++) { // ��÷��
				System.out.printf("%4d", mm[i][k]);

			}

			// �� �ٲٱ�
			System.out.println();
		}
	}

	public void fill(int[][] mm, int val) {
		for (int i = 0; i < mm.length; i++) {
			for (int k = 0; k < mm[i].length; k++) {
				mm[i][k] = val;

			}
		}
	}

	// ������ �ุ val�� ä���
	public void fill(int[][] mm, int rowIndex, int val) {
		for (int k = 0; k < mm[rowIndex].length; k++) {
			mm[rowIndex][k] = val;

		}
	}
	
	public void display_block(int[][] mm) {
		for (int i = 0; i < mm.length; i++) { // ��÷��
			for (int k = 0; k < mm[i].length; k++) { // ��÷��
				if(mm[i][k]==1) {
					System.out.printf("%3s","��");
				}else {
					System.out.printf("%3s"," ");
				}
			}
			System.out.println();
					
			}
}
}
