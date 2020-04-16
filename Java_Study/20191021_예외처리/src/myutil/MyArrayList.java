package myutil;

public class MyArrayList {

	// �ڹ��� ��� ��ü�� �����ϱ� ���ؼ�
	Object[] data = null;

	public void add(Object ob) {

		// ù��° �߰���
		if (data == null) {
			data = new Object[1];
			data[0] = ob;
			return;
		}

		// ���� �迭 �������� 1�� �� ���� �Ҵ�
		Object[] imsi = new Object[this.size() + 1]; // this�� MyArrayList�� ��Ī
		// ���� �����͸� imsi �迭�� �ű��.
		for (int i = 0; i < this.size(); i++) {
			imsi[i] = data[i];
		}
		// ���� ���� �� �������� �ִ´�.
		imsi[this.size()] = ob;

		// imsi > data
		data = imsi;

	}

	public int size() {
		return (data == null) ? 0 : data.length;
	}

	// get(index)�� ����ϴ� ����� ������ ����ó���ϵ���
	// ����
	public Object get(int index) throws Exception {

		// ���������� ���
		if (index < 0 || index >= this.size()) {
			String message = String.format("÷�ڻ����� 0~%d => ��û ÷�� : %d", this.size() - 1, index);
			// ���ܸ� ������ > �ܺΰ�ü���� ó�� ����
			throw new Exception(message);
		}

		return data[index];
	}

	public void remove(int i) throws Exception {
		if (i < 0 || i >= this.size()) {
			String message = String.format("÷�ڻ����� 0~%d => ��û ÷�� : %d", this.size() - 1, i);
			throw new Exception(message);

		}

		// ����ó��

		// 1�� ������ �� ����
		if (this.size() == 1) {
			data = null;
			return;
		}

		Object[] imsi = new Object[this.size() - 1];

		for (int k = 0; k < this.size() - 1; k++) {
			if (k < i) {
				imsi[k] = data[k];
			} else {
				imsi[k] = data[k + 1];
			}
		}

		data = imsi;
	}
}
