package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class MyMain_BaseCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BaseCalc.PI = 3.141592;
		System.out.println("BaseCalc.PI");
		// �б�� ����! �ֳ�!public �����Ǿ��־ �ٸ� package������ �� �ٲ����� ������ ���� �ȶ�

		// �������̽� = new Ŭ����();
		// ��� ����
		BaseCalc bc = new BaseCalcImpl();

		int a = 5, b = 10, res;

		res = bc.minus(a, b);
		System.out.printf("%d + %d = %d\n", a, b, res);

	}

}