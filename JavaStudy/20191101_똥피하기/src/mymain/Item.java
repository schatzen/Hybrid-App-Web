package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {

	//��ġ/ũ������ ��°�ü
	Rectangle pos   = new Rectangle();
	Color     color = Color.black; 
	
	public abstract void draw(Graphics g); //������ �ǹ�
	public boolean  move() { return false;}//������ ������
}
