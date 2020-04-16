package mymain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {

	//위치/크기정보 담는객체
	Rectangle pos   = new Rectangle();
	Color     color = Color.black; 
	
	public abstract void draw(Graphics g); //재정의 의무
	public boolean  move() { return false;}//선택적 재정의
}
