package mymain;

import myutil.Circle;
import myutil.Rect;
import myutil.Shape;
import myutil.Triangle;

public class MyMain_Shape {

	static void �׷���(Shape [] s_array) {
		for(Shape ���� : s_array) {
			����.draw();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape [] s_array = { 
				              new Rect(),
				              new Triangle(),
				              new Circle() 
				           };
		�׷���(s_array);
	}

}
