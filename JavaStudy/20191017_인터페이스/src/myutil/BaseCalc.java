package myutil;



public interface BaseCalc {

	public static final  double PI2 = 3.14;
	/*   생략  */         double PI  = 3.14;//상수로 인식
	                      
    public abstract int plus(int a,int b);	 
    /*   생략  */    int minus(int a,int b);//추상메소드로 인식
}


