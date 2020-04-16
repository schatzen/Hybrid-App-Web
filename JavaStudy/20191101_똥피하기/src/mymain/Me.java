package mymain;

import java.awt.Graphics;

public class Me extends Item{

	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect(pos.x, pos.y, pos.width, pos.height);
	}
	
	int gan = 8;
	public void move_left() {
		pos.x -= gan;
		
		if(pos.x<-pos.width) pos.x = GameConstant.GAMEPAN_W;
	}
	
	public void move_right() {
		pos.x += gan;
		
		if(pos.x > GameConstant.GAMEPAN_W) {
			pos.x = -pos.width;
		}
	}
	
	

}
