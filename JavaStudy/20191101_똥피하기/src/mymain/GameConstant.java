package mymain;

public class GameConstant {

	//상수
	public static final int GAMEPAN_W = 400;
	public static final int GAMEPAN_H = 600;
	                               
	//키상수
	public static class Key{
	
		public static final int NONE 	= 0;
		public static final int LEFT 	= 1;
		public static final int UP 	= 2;
		public static final int RIGHT 	= 4;
		public static final int DOWN 	= 8;
		
		public static final int LEFTUP 	= LEFT|UP;
		public static final int LEFTDOWN 	= LEFT|DOWN;
		public static final int RIGHTUP 	= RIGHT|UP;
		public static final int RIGHTDOWN 	= RIGHT|DOWN;
		
		
	}
	
	
	
}
