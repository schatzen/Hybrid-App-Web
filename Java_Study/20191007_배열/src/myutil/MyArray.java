package myutil;

// 1���� �迭�� ������ �������� ���� Ŭ����
public class MyArray {

	// ������� �� ����
	public void setArray(int[] ar) {

		for (int i = 0; i < ar.length; i++) {
			ar[i] = i + 1;

		}

	}

	// �迭��� => [1 2 3 4 ]
	public void displayArray(int[] ar) {
		System.out.print("[ ");

		for (int i = 0; i < ar.length; i++) {

			System.out.printf("%d ", ar[i]);

		}

		System.out.println(" ] ");

	}

	// �迭�� ���� ���ϴ� ���� ä���
	public void fill(int[] ar, int val) {
		for (int i = 0; i < ar.length; i++) {
			ar[i] = val;
		}

	}

	public void fil(int[] ar, int fromIndex, int toIndex, int val) {
		for (int i = fromIndex; i < toIndex; i++) {
			ar[i] = val;
		}
	}

	// ��������(Ascending Sort)
	public void array_asc(int[] ar) {
		// ��������(Selection Sort)
		for (int i = 0; i < ar.length - 1; i++) { // ���ذ�
			for (int k = i + 1; k < ar.length; k++) {
				if (ar[i] > ar[k])
					;
				int im = ar[i];
				ar[i] = ar[k];
				ar[k] = im;
			}
		}
	}

	// �������� (Descending Sort)
	public void array_desc(int[] ar) {
		// ��������(Selection Sort)
		for (int i = 0; i < ar.length - 1; i++) { // ���ذ�
			for (int k = i + 1; k < ar.length; k++) {
				if (ar[i] < ar[k])
					;
				int im = ar[i];
				ar[i] = ar[k];
				ar[k] = im;
			}
		}
	}

}
