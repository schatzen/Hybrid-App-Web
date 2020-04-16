package myutil;

// 1차원 배열을 관리할 목적으로 만든 클래스
public class MyArray {

	// 순서대로 값 세팅
	public void setArray(int[] ar) {

		for (int i = 0; i < ar.length; i++) {
			ar[i] = i + 1;

		}

	}

	// 배열출력 => [1 2 3 4 ]
	public void displayArray(int[] ar) {
		System.out.print("[ ");

		for (int i = 0; i < ar.length; i++) {

			System.out.printf("%d ", ar[i]);

		}

		System.out.println(" ] ");

	}

	// 배열에 내가 원하는 값을 채우기
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

	// 오름차순(Ascending Sort)
	public void array_asc(int[] ar) {
		// 선택정렬(Selection Sort)
		for (int i = 0; i < ar.length - 1; i++) { // 기준값
			for (int k = i + 1; k < ar.length; k++) {
				if (ar[i] > ar[k])
					;
				int im = ar[i];
				ar[i] = ar[k];
				ar[k] = im;
			}
		}
	}

	// 내림차순 (Descending Sort)
	public void array_desc(int[] ar) {
		// 선택정렬(Selection Sort)
		for (int i = 0; i < ar.length - 1; i++) { // 기준값
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
