package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_��� {

	static void use_basecalc(BaseCalc bc) {
		// BaseCalc bc = ac;
		// up-casting (�ڵ�����ȯ / ��뿵���� ���)

		System.out.println("--only BaseCalc�� ���--");
		int a = 10, b = 5, res;
		res = bc.minus(a, b);
		System.out.printf("use_basecalc : %d - %d = %d\n\n", a, b, res);

		// res = bc.hap(a);

	}

	static void use_object(Object ob) {

		// down-casting(��������ȯ / ��뿵���� Ȯ��)
		System.out.println("--�ٿ� ĳ���� ���--");
		int n = 5, res;
		res = ((AdvanceCalc) ob).hap(n);
		System.out.printf("%d������ �� = %d\n\n", n, res);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 10, y = 3, res;

		AdvanceCalc ac = new AdvanceCalc();
		// use_basecalc ȣ��
		use_basecalc(ac);
		// use_object ȣ��
		use_object(ac);

		System.out.println("--���� �ڵ� ���--");
		res = ac.plus(x, y);
		System.out.printf("%d + %d = %d\n", x, y, res);

		res = ac.hap(x);
		System.out.printf("%d������ �� = %d\n", x, res);

		// down-casting�� �� ���ǻ���
		BaseCalc bc1 = new BaseCalc();
		
		//��ü ���� AdvanceCalc����� ����.
		AdvanceCalc ac1 = (AdvanceCalc) bc1;
		//AdvanceCalc�� ��������� ���� ���¿��� ���� ����ȯ�Ϸ��� �� > ���ϳ� �ɺ�!

	}

}
