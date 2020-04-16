package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungManager {

	public static final int MAKE_INTERVAL = 20;
		
	List<Dung> dung_list = new ArrayList<Dung>();
	
	Random rand = new Random();
	
	int make_interval = MAKE_INTERVAL;
	
	Color [] colors = { 
			            Color.red,
			            Color.green,
			            Color.blue,
			            Color.yellow,
			            Color.magenta,
			            Color.cyan,
			            Color.black
			           };
	public void make_dung() {
		
		if(make_interval==MAKE_INTERVAL)
		{
			Dung dung = new Dung();
			dung.pos.width = Dung.WIDTH;
			dung.pos.height= Dung.HEIGHT;
			dung.pos.x = rand.nextInt(GameConstant.GAMEPAN_W)-Dung.WIDTH/2;
			dung.pos.y = -Dung.HEIGHT;
			
			int index  = rand.nextInt(colors.length); //0~6
			dung.color = colors[index];
			dung.speed = rand.nextInt(3)+2;//2~4
			
			dung_list.add(dung);
		}
		
		make_interval--;
		if(make_interval<0)
			make_interval = MAKE_INTERVAL;
		
		
	}
	
	public void draw_all(Graphics g) {
		
		for(int i=0;i<dung_list.size();i++) {
			Dung dung = dung_list.get(i);
			dung.draw(g);
		}
	}
	
	
	public void move_all() {
		
		for(int i=0;i<dung_list.size();i++) {
			Dung dung = dung_list.get(i);
			
			//화면 아래로 내려갔으면 제거한다
			if(dung.move()) {
				dung_list.remove(dung);
			}
		}
	}
	
}
