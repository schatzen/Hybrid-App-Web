package mymain;

import java.awt.Graphics;

public class Me extends Item {

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(color);
		g.fillRect(pos.x, pos.y, pos.width, pos.height); // Item���� ��ӹ޾����� pos������� �ᵵ ����

	}

	int gan = 5;

	public void move_left() {
		pos.x -= gan;

		if (pos.x < 0) {
			pos.x = -(pos.width / 2);
		}

	}

	public void move_right() {
		pos.x += gan;
		
		if (pos.x + pos.width/2 > GameConstatnt.GAMEPAN_W) {
			pos.x = GameConstatnt.GAMEPAN_W - pos.width / 2;
		}

	}

	@Override
	public boolean move() { // ������ ����
		// TODO Auto-generated method stub
		return super.move();
	}

}
