package myutil;

public class AdvanceCalc extends BaseCalc {

	public int hap(int n) {
		int sum = 0;

		for (int i = 1; i <= n; i++)
			// 부모의 기능을 사용
			sum = super.plus(sum, i);

		return sum;

	}

	public int pow(int n, int m) {
		int res = 1;

		for (int i = 0; i < m; i++)
			// 부모의 기능을 사용
			res = super.multiply(res, n);

		return res;

	}

}
