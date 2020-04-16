package mymain;

import myutil.Animal;
import myutil.Cat;
import myutil.Circle;
import myutil.Dog;
import myutil.Pig;
import myutil.Rect;
import myutil.Shape;
import myutil.Triangle;

public class MyMain_abstract {

	public static void main(String[] args) {

		Animal[] a_array = { new Dog(), new Cat(), new Pig() };
		Shape[] s_array = { new Rect(), new Triangle(), new Circle() };

		������(a_array);
		�׷���(s_array);
	}

	static void ������(Animal[] a_array) {
		System.out.println("--������--");
		for (Animal ���� : a_array) {
			����.cry();
			����.eat();

		}
		System.out.println();

	}

	static void �׷���(Shape[] s_array) {
		System.out.println("--����--");
		for (Shape ���� : s_array)
			����.draw();
		System.out.println();

	}

}
