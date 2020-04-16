package mymain;

import myutil.Circle;
import myutil.Rect;
import myutil.Shape;
import myutil.Triangle;

public class MyMain_Shape {

	static void 그려라(Shape [] s_array) {
		for(Shape 도형 : s_array) {
			도형.draw();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape [] s_array = { 
				              new Rect(),
				              new Triangle(),
				              new Circle() 
				           };
		그려라(s_array);
	}

}
