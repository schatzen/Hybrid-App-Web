package myutil;

public class BaseCalcImpl implements BaseCalc {
	
	//반드시 BaseCalcImpl은 BaseCalc를 반드시 재정의해야한다.

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
