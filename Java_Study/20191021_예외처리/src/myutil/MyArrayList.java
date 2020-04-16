package myutil;

public class MyArrayList {

	// 자바의 모든 객체를 저장하기 위해서
	Object[] data = null;

	public void add(Object ob) {

		// 첫번째 추가시
		if (data == null) {
			data = new Object[1];
			data[0] = ob;
			return;
		}

		// 이전 배열 갯수보다 1개 더 많게 할당
		Object[] imsi = new Object[this.size() + 1]; // this는 MyArrayList를 지칭
		// 이전 데이터를 imsi 배열에 옮긴다.
		for (int i = 0; i < this.size(); i++) {
			imsi[i] = data[i];
		}
		// 새로 들어온 값 마지막에 넣는다.
		imsi[this.size()] = ob;

		// imsi > data
		data = imsi;

	}

	public int size() {
		return (data == null) ? 0 : data.length;
	}

	// get(index)을 사용하는 사용자 측에서 예외처리하도록
	// 위임
	public Object get(int index) throws Exception {

		// 비정상적인 경우
		if (index < 0 || index >= this.size()) {
			String message = String.format("첨자사용범위 0~%d => 요청 첨자 : %d", this.size() - 1, index);
			// 예외를 던진다 > 외부객체에게 처리 위임
			throw new Exception(message);
		}

		return data[index];
	}

	public void remove(int i) throws Exception {
		if (i < 0 || i >= this.size()) {
			String message = String.format("첨자사용범위 0~%d => 요청 첨자 : %d", this.size() - 1, i);
			throw new Exception(message);

		}

		// 삭제처리

		// 1개 남았을 때 삭제
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
