package myutil;

public class BaseCalcImpl implements BaseCalc {
	
	//�ݵ�� BaseCalcImpl�� BaseCalc�� �ݵ�� �������ؾ��Ѵ�.

	@Override
	public int plus(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int minus(int a, int b) {
		int c;
		int d;
		
		c = (a > b) ? a : b;
		
		if( c == a )
			d = a - b;
		else
			d = b - a;
			
		return d;
	}
	
	

}
