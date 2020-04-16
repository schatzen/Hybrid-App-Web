package mymain;

import myutil.Lotto;
import myutil.MyArray;

public class MyMain_lotto {

	public static void main(String[] args) {
		int[] lotto_no = new int[6];

		MyArray ma = new MyArray();
		Lotto lotto = new Lotto();
		lotto.make_lotto(lotto_no);
		
		System.out.println("--추출된 번호--");
		ma.array_asc(lotto_no);
		ma.displayArray(lotto_no);

	}

}
