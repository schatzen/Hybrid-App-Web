package mymain;

import java.awt.Color;
import java.awt.Graphics;

public class Dung extends Item{

	public final static int WIDTH  = 30;
	public final static int HEIGHT = 30;
	
	int speed=1;//하강속도
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillOval(pos.x, pos.y, pos.width, pos.height);
		
		//테두리..
		g.setColor(Color.yellow);
		g.drawRect(pos.x, pos.y, pos.width, pos.height);
	}
	
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		
		pos.y += speed;//아래로 이동
		//         화면(밖)아래로 벗어났냐? 
		return (pos.y > GameConstant.GAMEPAN_H);
	}
	
	

}
