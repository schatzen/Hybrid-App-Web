package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungManager {

	public static final int MAKE_INTERVAL = 20;

	List<Dung> dungList = new ArrayList<Dung>();

	Color color1 = new Color(87, 114, 132);
	Color color2 = new Color(85, 180, 176);
	Color color3 = new Color(240, 234, 214);
	Color color4 = new Color(97, 85, 80);
	Color color5 = new Color(52, 49, 72);

	Color[] colors = { color1, color2, color3, color4, color5 };
	Random rand = new Random();

	int make_interval = MAKE_INTERVAL;

	public void make_dung() {
		if (make_interval == MAKE_INTERVAL) {
			Dung dung = new Dung();
			dung.pos.width = Dung.WIDTH;
			dung.pos.height = Dung.HEIGHT;

			dung.pos.x = rand.nextInt(GameConstatnt.GAMEPAN_W) - Dung.WIDTH / 2;
			dung.pos.y = -Dung.HEIGHT;

			int index = rand.nextInt(colors.length);
			dung.color = colors[index];
			dung.speed = rand.nextInt(3) + 2;

			dungList.add(dung);
		}
		make_interval--;
		if (make_interval < 0)
			make_interval = MAKE_INTERVAL;

	}

	public void draw_all(Graphics g) {

		for (int i = 0; i < dungList.size(); i++) {
			Dung dung = dungList.get(i);
			dung.draw(g);

		}

	}

	public void move_all() {
		for (int i = 0; i < dungList.size(); i++) {
			Dung dung = dungList.get(i);

			// 화면 아래로 내려갔으면 제거한다.
			if (dung.move())
				dungList.remove(dung);

		}

	}
}
